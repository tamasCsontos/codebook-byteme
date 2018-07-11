package com.codecool.codebook.controller;

import com.codecool.codebook.Password;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class UserController{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Password bcrypt;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password){
        String hashedPassword = studentRepository.findByEmail(email).getPassword();
        if (bcrypt.checkPassword(password, hashedPassword)) {
            session.setAttribute("userID", studentRepository.findByEmail(email).getId());
            session.setAttribute("email", email);
            System.out.println(session.getAttribute("email"));
            return "redirect:/";

        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        if (session.getAttribute("userID") != null){
            session.invalidate();

        }
        return "redirect:/";
    }


    @GetMapping("/registration")
    public String displayRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("password") String password) {

        String hashedPAssword = bcrypt.hashPassword(password);
        Student newStudent = new Student(name, email, hashedPAssword);
        studentRepository.save(newStudent);
        return "redirect:/";
    }




}
