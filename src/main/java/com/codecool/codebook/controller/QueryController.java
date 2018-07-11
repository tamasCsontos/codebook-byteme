package com.codecool.codebook.controller;


import com.codecool.codebook.sql.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(path = "/check")
    public boolean checkEmailExistence(@RequestParam("email") String email){
        if (queries.getStudent(email) != null) return true;
        return false;
    }

    @GetMapping(path = "/check")
    public void checkRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

}
