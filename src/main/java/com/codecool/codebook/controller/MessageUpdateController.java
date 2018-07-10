/*
package com.codecool.codebook.controller;

import com.codecool.codebook.model.Message;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUpdateController extends HttpServlet {

    Queries queries;

    public MessageUpdateController(Queries queries) {
        this.queries = queries;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("userID") != null) {
            Long receiverId = Long.valueOf(req.getParameter("id"));
            Long senderId = new Long((int) session.getAttribute("userID"));
            List<Message> messages = queries.getAllMessageBetweenUsers(senderId, receiverId);
            JSONObject messageJson = new JSONObject();
            List<Map> mapsForMessage = new ArrayList<>();
            for (Message message : messages) {
                Map<String, String> messageMap = new HashMap<>();
                Student sender = message.getSenderStudent();
                String senderName = sender.getName();
                String textMessage = message.getTextMessage();
                messageMap.put("sender", senderName);
                messageMap.put("text_message", textMessage);
                mapsForMessage.add(messageMap);
            }
            messageJson.put("messages", mapsForMessage);
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(messageJson);
            out.flush();
        }

    }
}
*/
