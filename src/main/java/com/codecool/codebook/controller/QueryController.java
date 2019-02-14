package com.codecool.codebook.controller;


import com.codecool.codebook.model.Student;
import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.StudentRepository;
import com.codecool.codebook.repository.WorkplaceRepository;
import com.codecool.codebook.sql.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class QueryController extends HttpServlet {

    @Autowired
    Queries queries;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    WorkplaceRepository workplaceRepository;

    @PostMapping(path = "/check")
    public boolean checkEmailExistence(@RequestParam("email") String email){
        if (queries.getStudent(email) != null) return true;
        return false;
    }

    @GetMapping(path = "/check")
    public void checkRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

    @PostMapping("/save")
    public String save(Model model, @RequestParam("name")String name,
                     @RequestParam("phone")String phone,
                     @RequestParam("feedback")String feedback,
                     @RequestParam("id")String id,
                     @RequestParam("workplace")String workplace){

        Student student = studentRepository.getOne(Long.valueOf(id));
        Workplace newWorkplace = workplaceRepository.findByNameEquals(workplace);

        if(feedback.equals("")){
            feedback = null;
        }

        if(newWorkplace == null){
            feedback = null;
        } else if (student.getWorkplace() != null) {
            if (!student.getWorkplace().getName().equals(newWorkplace.getName())) {
                feedback = null;
            }
        }


        student.setPhonenumber(phone);
        student.setName(name);
        student.setWorkplace(newWorkplace);
        student.setWorkplaceFeedback(feedback);
        studentRepository.save(student);

        return "success";
    }

    @PostMapping("/checkWorkplace")
    public boolean checkWorkplace(@RequestParam("id")String id,
                                  @RequestParam("workplace")String workplace){
        Student student = studentRepository.getOne(Long.valueOf(id));
        Workplace newWorkplace = workplaceRepository.findByNameEquals(workplace);

        if (student.getWorkplace() != null && newWorkplace != null){

            return student.getWorkplace().getName().equals(newWorkplace.getName());
        } else if (student.getWorkplace() == null && newWorkplace != null){

            return false;
        } else return false;
    }

}
