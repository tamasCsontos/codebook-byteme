package com.codecool.codebook.controller;

import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.StudentRepository;
import com.codecool.codebook.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkplaceController {
    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    StudentRepository studentRepository;



    @Autowired
    HttpSession session;

    @GetMapping("/workplaces")
    public String listWorkplaces(Model model){
        List<Workplace> workplaces =workplaceRepository.findAll();
        String email = (String) session.getAttribute("email");
        model.addAttribute("user", studentRepository.findByEmail(email));
        model.addAttribute("workplaces", workplaces);
        return "workplaces";
    }

    @GetMapping("/workplace/{id}")
    public String showWorkplace(Model model, @PathVariable("id")String id){
        Workplace workplace = workplaceRepository.getOne(Long.valueOf(id));
        model.addAttribute(workplace);
        return "workplace";
    }
}