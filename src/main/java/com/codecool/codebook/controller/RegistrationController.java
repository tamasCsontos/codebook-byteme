package com.codecool.codebook.controller;

import com.codecool.codebook.Mailer;
import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.Password;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("registration.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phonenumber");

        String hashedPAssword = Password.hashPassword(password);
        Student newStudent = new Student(name, email, hashedPAssword);

        if (phoneNumber != null){
            newStudent.setPhonenumber(phoneNumber);
        }
        Queries.addNewStudent(newStudent);
        Mailer mailer = new Mailer();
        mailer.sendWelcome(request);

        response.sendRedirect("/");
    }
}
