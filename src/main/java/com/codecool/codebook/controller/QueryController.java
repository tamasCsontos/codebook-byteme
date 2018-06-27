package com.codecool.codebook.controller;


import com.codecool.codebook.sql.Queries;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class QueryController extends HttpServlet {
    Queries queries;


    public QueryController(Queries queries){
        this.queries = queries;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String email = req.getParameter("email");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (queries.getStudent(email) != null){
            out.print("true");

        } else {
            out.print("false");
        }

        out.flush();
        out.close();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

}
