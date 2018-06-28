package com.codecool.codebook.controller;

import com.codecool.codebook.sql.Queries;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    private IndexController indexController;
    private LoginController loginController;
    private LogoutController logoutController;
    private MessageController messageController;
    private RegistrationController registrationController;
    private SpecificWorkplaceController specificWorkplaceController;
    private StudentController studentController;
    private WorkplaceController workplaceController;
    private Queries queries;
    private MessageUpdateController messageUpdateController;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        instantiateQueries();
        instantiateControllers();

        context.addServlet("indexController", indexController).addMapping("/");
        context.addServlet("loginController", loginController).addMapping("/login");
        context.addServlet("logoutController", logoutController).addMapping("/logout");
        context.addServlet("messageController", messageController).addMapping("/message/*");
        context.addServlet("registrationController", registrationController).addMapping("/registration");
        context.addServlet("specificWorkplaceController", specificWorkplaceController).addMapping("/workplace/*");
        context.addServlet("studentController", studentController).addMapping("/student/*");
        context.addServlet("workplaceController", workplaceController).addMapping("/workplaces");
        context.addServlet("messageUpdateController", messageUpdateController).addMapping("/messageupdate/*");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void instantiateControllers(){
        indexController = new IndexController(queries);
        loginController = new LoginController(queries);
        logoutController = new LogoutController();
        messageController = new MessageController(queries);
        registrationController = new RegistrationController(queries);
        specificWorkplaceController = new SpecificWorkplaceController(queries);
        studentController = new StudentController(queries);
        workplaceController = new WorkplaceController(queries);
        messageUpdateController = new MessageUpdateController(queries);
    }

    private void instantiateQueries() {
        queries = new Queries(Persistence.createEntityManagerFactory("codebookPU"));
    }
}
