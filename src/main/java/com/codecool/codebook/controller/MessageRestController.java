package com.codecool.codebook.controller;

import com.codecool.codebook.model.Message;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageRestController {

    @Autowired
    HttpSession session;

    @Autowired
    Queries queries;

    @GetMapping("/messageupdate")
    public Map<String, List> showMessage(@RequestParam("id") String receiverId) throws JSONException {
        if (session.getAttribute("userID") != null) {
            Long senderId = (Long) session.getAttribute("userID");
            List<Message> messages = queries.getAllMessageBetweenUsers(senderId, Long.valueOf(receiverId));
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
            Map<String, List> json = new HashMap();
            json.put("messages", mapsForMessage);
            return json;
        }
        return null;
    }
}
