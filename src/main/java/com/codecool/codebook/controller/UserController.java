package com.codecool.codebook.controller;

import com.codecool.codebook.Password;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Password bcrypt;

    @GetMapping("/login")
    public String displayLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        String hashedPassword = studentRepository.findByEmail(email).getPassword();
        if (bcrypt.checkPassword(password, hashedPassword)) {
            return "redirect:index";
        }
        return "login";
    }
}
