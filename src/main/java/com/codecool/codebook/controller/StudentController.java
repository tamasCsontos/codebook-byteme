package com.codecool.codebook.controller;

import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentController extends HttpServlet {
    Queries queries;

    public StudentController(Queries queries) {
        this.queries = queries;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long pathParameter = Long.valueOf(req.getParameter("id"));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Student student = queries.getStudent(pathParameter);
        context.setVariable("student", queries.getStudent(pathParameter));
        if (student.getWorkplace() != null){
            context.setVariable("workplace", queries.getStudentWorkplace(pathParameter));
        } else {
            context.setVariable("workplace", "No Workplace");
        }
        if (student.getKlass() != null){
            context.setVariable("klass", queries.getStudentKlass(pathParameter));
        } else {
            context.setVariable("klass", "No Klass");
        }
        engine.process("student.html", context, resp.getWriter());
    }
}