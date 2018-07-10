package com.codecool.codebook.controller;

import com.codecool.codebook.model.Student;
import com.codecool.codebook.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/student/{id}")
    public String showStudent(Model model, @RequestParam("id")String id){
        Student student = studentRepository.getOne(Long.valueOf(id));
        model.addAttribute("student", student);
        return "student";
    }

}