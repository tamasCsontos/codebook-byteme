//package com.codecool.codebook.service;
//
//import com.codecool.codebook.model.Location;
//import com.codecool.codebook.model.*;
//import com.codecool.codebook.repository.*;
//import org.springframework.stereotype.Component;
//
//@Component
//public class InitializerBean {
//
//    public InitializerBean(ActualJobRepository actualJobRepository,
//                           KlassRepository klassRepository,
//                           MessageRepository messageRepository,
//                           SchoolRepository schoolRepository,
//                           StudentRepository studentRepository,
//                           WorkplaceRepository workplaceRepository) {
//        //Generate Students
//        Student student1 = new Student("Gipsz Jakab", "jakab@mail.hu", "examplepassword");
//        Student student2 = new Student("Cink Elek", "c.elek@gmail.com", "examplepassword");
//        Student student3 = new Student("Kukor Ica", "kica@mail.hu", "examplepassword");
//        Student student4 = new Student("Ultra Ibolya", "ibi@mail.hu", "examplepassword");
//        Student student5 = new Student("Trap Pista", "t.pista@mail.hu", "examplepassword");
//        Student student6 = new Student("Szalmon Ella", "ella@mail.hu", "examplepassword");
//        Student student7 = new Student("Ipsz Ilonka", "y@mail.hu", "examplepassword");
//        Student student8 = new Student("Metall Ica", "icu@mail.hu", "examplepassword");
//        Student student9 = new Student("Mesz Eli", "eli@mail.hu", "examplepassword");
//        Student student10 = new Student("Test User", "testuser", "$2a$12$dUNGULRkxdREqZ4Fb8npUey.sAjVm4qnIngMsvIWcr0mo9n.6wgQa");
//        Student student11 = new Student("Admin", "admin@admin.com", "$2a$12$q4ejD4qRINaqcMYfLhugCOEYj8wcNDjQOZeSUVd5kngUGJ5XL8mOe");
//
//        //Genarate Workplaces
//        Workplace workPlace1 = new Workplace("Facebook", "Community site.");
//        Workplace workPlace2 = new Workplace("Microsoft", "Windows operation system and other things");
//        Workplace workPlace3 = new Workplace("Google", "Search engine and a lot of other cool stuff");
//
//        //Generate School
//        School school1 = new School(Location.BUDAPEST);
//
//        //Generate Klasses
//        Klass klass1 = new Klass("BP1");
//        Klass klass2 = new Klass("BP2");
//
//        //Generate Actual Jobs
//        ActualJob actualJob1 = new ActualJob("Software Developer", "Write softwares");
//        ActualJob actualJob2 = new ActualJob("Test Writer", "Write tests");
//
//        //Make connections
//        klass1.addStudent(student1);
//        klass1.addStudent(student2);
//        klass1.addStudent(student3);
//        klass1.addStudent(student4);
//        klass1.addStudent(student5);
//        klass2.addStudent(student6);
//        klass2.addStudent(student7);
//        klass2.addStudent(student8);
//        klass2.addStudent(student9);
//        klass1.addStudent(student10);
//
//        workPlace1.addStudent(student1);
//        workPlace1.addStudent(student2);
//        workPlace1.addStudent(student3);
//        workPlace2.addStudent(student4);
//        workPlace2.addStudent(student5);
//        workPlace3.addStudent(student6);
//        workPlace3.addStudent(student7);
//        workPlace1.addStudent(student10);
//
//        workPlace1.addActualJob(actualJob1);
//        workPlace2.addActualJob(actualJob2);
//
//        student1.setWorkplaceFeedback("This is a cool place!");
//        student2.setWorkplaceFeedback("I like to work here!");
//        student4.setWorkplaceFeedback("This is a shitty place. I want to die!");
//        student6.setWorkplaceFeedback("It's okay");
//        student10.setWorkplaceFeedback("I'm just a test user");
//
//        student1.setPhonenumber("06301234567");
//        student2.setPhonenumber("06307654321");
//        student3.setPhonenumber("06305555555");
//        student4.setPhonenumber("06304829495");
//        student5.setPhonenumber("06306295955");
//        student6.setPhonenumber("06301258458");
//        student7.setPhonenumber("06308755684");
//        student8.setPhonenumber("06308655669");
//        student9.setPhonenumber("06306668485");
//        student10.setPhonenumber("06306666666");
//
//        //Save information
//        workplaceRepository.save(workPlace1);
//        workplaceRepository.save(workPlace2);
//        workplaceRepository.save(workPlace3);
//        schoolRepository.save(school1);
//        klassRepository.save(klass1);
//        klassRepository.save(klass2);
//        actualJobRepository.save(actualJob1);
//        actualJobRepository.save(actualJob2);
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//        studentRepository.save(student3);
//        studentRepository.save(student4);
//        studentRepository.save(student5);
//        studentRepository.save(student6);
//        studentRepository.save(student7);
//        studentRepository.save(student8);
//        studentRepository.save(student9);
//        studentRepository.save(student10);
//        studentRepository.save(student11);
//    }
//}
