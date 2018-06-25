package com.codecool.codebook.controller;


import com.codecool.codebook.Password;
import com.codecool.codebook.config.TemplateEngineUtil;
import com.codecool.codebook.sql.Queries;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    Queries queries;

    public LoginController(Queries queries) {
        this.queries = queries;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());


        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashedPWFromDB = queries.getPassword(email);
        int userID = queries.getID(email);

        try {
            if (hashedPWFromDB == null | !Password.checkPassword(password, hashedPWFromDB) | userID < 0) {

                context.setVariable("onError", "Wrong email or password");
                engine.process("login.html", context, response.getWriter());

            } else {

                HttpSession session = request.getSession();
                session.setAttribute("userID", userID);
                session.setAttribute("email", email);

                response.sendRedirect("/");
            }
        }catch (IllegalArgumentException e){
            System.err.println("Error caught: " + e.toString());

            context.setVariable("onError", "Wrong email or password");
            engine.process("login.html", context, response.getWriter());

        }
    }
}
