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

        Long pathParameter = Long.valueOf(req.getParameter("id"));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Student student = Queries.getStudent(pathParameter);
        context.setVariable("student", Queries.getStudent(pathParameter));
        if (student.getWorkplace() != null){
            context.setVariable("workplace", Queries.getStudentWorkplace(pathParameter));
        } else {
            context.setVariable("workplace", "No Workplace");
        }
        if (student.getKlass() != null){
            context.setVariable("klass", Queries.getStudentKlass(pathParameter));
        } else {
            context.setVariable("klass", "No Klass");
        }
        engine.process("student.html", context, resp.getWriter());
    }
}