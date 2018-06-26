package com.codecool.codebook.controller;

import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.model.Message;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MessageController extends HttpServlet {
    Queries queries;

    public MessageController(Queries queries) {
        this.queries = queries;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        HttpSession session = req.getSession();
        if (session.getAttribute("userID") != null){
            Long receiverId = Long.valueOf(req.getParameter("id"));
            Long senderId = new Long((int) session.getAttribute("userID"));
            Student senderStudent = queries.getStudent(senderId);
            Student recieverStudent = queries.getStudent(receiverId);
            context.setVariable("student1", senderStudent);
            context.setVariable("student2", recieverStudent);
            context.setVariable("messages", queries.getAllMessageBetweenUsers(senderId, receiverId));
            engine.process("message.html", context, resp.getWriter());
        } else {
            engine.process("messageerror.html", context, resp.getWriter());

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long receiverId = Long.valueOf(request.getParameter("id"));
        HttpSession session = request.getSession();
        Long senderId = new Long((int) session.getAttribute("userID"));
        String textMessage = request.getParameter("message");
        Message message = new Message(textMessage);
        message.setReceiverStudent(queries.getStudent(receiverId));
        message.setSenderStudent(queries.getStudent(senderId));
        queries.addNewMessage(message);

        response.sendRedirect("/message/?id=" + receiverId);
    }
}