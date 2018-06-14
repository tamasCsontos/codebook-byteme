package com.codecool.codebook.controller;

import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

import com.codecool.codebook.sql.Queries;
import org.thymeleaf.exceptions.TemplateProcessingException;

@WebServlet(urlPatterns = {"/student/*"})
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long pathParameter = Long.valueOf(req.getParameter("id"));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("student", Queries.getStudentInfo(pathParameter));
        try {
            engine.process("student.html", context, resp.getWriter());
        }catch (TemplateProcessingException e){
            resp.resetBuffer();
            context.clearVariables();
            context.setVariable("traceback", e);
            engine.process("error.html", context, resp.getWriter());
            e.printStackTrace();
        }
    }
}