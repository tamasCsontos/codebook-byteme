package com.codecool.codebook.controller;


import com.codecool.codebook.model.ActualJob;
import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.ActualJobRepository;
import com.codecool.codebook.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    ActualJobRepository actualJobRepository;




    @PostMapping("/addWorkplace")
    public boolean addWorkplace(@RequestParam("name") String name, @RequestParam("description") String description){
        Workplace workplace = new Workplace(name, description);
        workplaceRepository.save(workplace);
        return true;
    }

    @PostMapping("/addActualjob")
    public boolean addActualJob(@RequestParam("name") String name, @RequestParam("workplace")String workplacename, @RequestParam("description") String description){
        ActualJob actualJob = new ActualJob(name, description);
        Workplace workplace = workplaceRepository.findByNameEquals(workplacename);
        workplace.addActualJob(actualJob);
        workplaceRepository.save(workplace);
        actualJobRepository.save(actualJob);

        return true;
    }


}
