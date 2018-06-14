package com.codecool.codebook.controller;

import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = {"/workplaces"})
public class WorkplaceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        HttpSession session = req.getSession();

        try {
            Long id = new Long((int) session.getAttribute("userID"));
            context.setVariable("userName", Queries.getStudent(id));
        } catch (NullPointerException e) {
            System.err.println("Error caught: " + e.toString() + " in WorkplaceController.doGet()");
        }

        context.setVariable("workplaces", Queries.getAllWorkplace());
        engine.process("workplaces.html", context, resp.getWriter());
    }
}