package com.codecool.codebook;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class Mailer {
    public void sendWelcome(HttpServletRequest req){
        // Recipient's email ID needs to be mentioned.
        String to = req.getParameter("email");

        // Sender's email ID needs to be mentioned
        String from = "codebookbyteme" +
                "@gmail.com";

        // Assuming you are sending email from localhost
        String host = "0.0.0.0";

        // Get system properties
        Properties properties = new Properties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Get the default Session object.
        Session session = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("codebookbyteme", "byteme666");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from, "CodeBook Team"));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Thank you for using CodeBook!");

            // Now set the actual message
            message.setText("Dear " + req.getParameter("name") + "," + "\n" +
                    " \nThank you for joining our site.\n " +
                    "\nWe hope you will enjoy our service. Have a nice day!" +
                    "\nBest Regards,\n"+
                    "\nThe CodeBook Team:"+
                    "\nBalogh Dávid"+
                    "\nCsontos Tamás"+
                    "\nOláh Tamás"+
                    "\nVártok Soma"+
                    "\nZibár András");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
