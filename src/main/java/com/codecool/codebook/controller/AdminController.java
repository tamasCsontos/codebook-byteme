package com.codecool.codebook.controller;


import com.codecool.codebook.model.ActualJob;
import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.ActualJobRepository;
import com.codecool.codebook.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    ActualJobRepository actualJobRepository;

    @GetMapping
    public String goToAdmin(@SessionAttribute String email, Model model){
        if (email.equals("admin@admin.com")) {
            List<Workplace> workplaces = workplaceRepository.findAll();
            model.addAttribute("workplaces", workplaces);
            return "admin";
        }else{
            return "index";
        }
    }


    @PostMapping("/addWorkplace")
    public String addWorkplace(@RequestParam("workplace_name") String name, @RequestParam("workplace_description") String description){
        Workplace workplace = new Workplace(name, description);
        workplaceRepository.save(workplace);
        return "redirect:admin";
    }

    @PostMapping("/addActualjob")
    public String addActualJob(@RequestParam("actual_job_name-field") String name, @RequestParam("workplace") Workplace workplace, @RequestParam("actual_job_description") String description){
        ActualJob actualJob = new ActualJob(name, description);
        actualJobRepository.save(actualJob);
        actualJob.setWorkplace(workplace);
        return "redirect:admin";
    }


}
