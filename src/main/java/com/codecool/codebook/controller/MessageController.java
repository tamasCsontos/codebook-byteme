package com.codecool.codebook.controller;

import com.codecool.codebook.model.Message;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.repository.StudentRepository;
import com.codecool.codebook.sql.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MessageController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HttpSession session;

    @Autowired
    Queries queries;

    @GetMapping("/message")
    public String showMessage(Model model, @RequestParam("id") String receiverId){
        if (session.getAttribute("userID") != null){
            Long senderId = (Long) session.getAttribute("userID");
            Student senderStudent = studentRepository.getOne(senderId);
            Student receiverStudent = studentRepository.getOne(Long.valueOf(receiverId));
            model.addAttribute("student1", senderStudent);
            model.addAttribute("student2", receiverStudent);
            model.addAttribute("messages", queries.getAllMessageBetweenUsers(senderId, Long.valueOf(receiverId)));
            model.addAttribute("queries", queries);
            return "message";
        } else {
            return "messageerror";
        }
    }

    @PostMapping("/message")
    public String sendMessage(@RequestParam("id") String receiverId, @RequestParam("message") String textMessage){
        Long senderId = (Long) session.getAttribute("userID");
        Message message = new Message(textMessage);
        message.setReceiverStudent(queries.getStudent(Long.valueOf(receiverId)));
        message.setSenderStudent(queries.getStudent(senderId));
        queries.addNewMessage(message);

        return "redirect:message?id=" + receiverId;
    }

}
