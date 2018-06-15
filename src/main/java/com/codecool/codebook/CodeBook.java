package com.codecool.codebook;

import com.codecool.codebook.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CodeBook {
    public static void populateDb(EntityManager em) {

        Student student = new Student("Testname", "e@mail.hu", "examplepassword");
        Workplace workPlace = new Workplace("Tname", "Tdesc");
        School school = new School(Location.BUDAPEST);
        Klass klass = new Klass("BPtest");
        ActualJob actualJob = new ActualJob("Tjob", "Tjobdesc");
        Message message = new Message("asd");

        klass.addStudent(student);
        workPlace.addStudent(student);
        workPlace.addActualJob(actualJob);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(school);
        em.persist(klass);
        em.persist(message);
        em.persist(actualJob);
        em.persist(student);
        em.persist(workPlace);
        transaction.commit();
    }

    public static void populateDbForDemo(EntityManager em) {
        //Generate Students
        Student student1 = new Student("Gipsz Jakab", "jakab@mail.hu", "examplepassword");
        Student student2 = new Student("Cink Elek", "c.elek@gmail.com", "examplepassword");
        Student student3 = new Student("Kukor Ica", "kica@mail.hu", "examplepassword");
        Student student4 = new Student("Ultra Ibolya", "ibi@mail.hu", "examplepassword");
        Student student5 = new Student("Trap Pista", "t.pista@mail.hu", "examplepassword");
        Student student6 = new Student("Szalmon Ella", "ella@mail.hu", "examplepassword");
        Student student7 = new Student("Ipsz Ilonka", "y@mail.hu", "examplepassword");
        Student student8 = new Student("Metall Ica", "icu@mail.hu", "examplepassword");
        Student student9 = new Student("Mesz Eli", "eli@mail.hu", "examplepassword");

        //Genarate Workplaces
        Workplace workPlace1 = new Workplace("Facebook", "Community site.");
        Workplace workPlace2 = new Workplace("Microsoft", "Windows operation system and other things");
        Workplace workPlace3 = new Workplace("Google", "Search engine and a lot of other cool stuff");

        //Generate School
        School school1 = new School(Location.BUDAPEST);

        //Generate Klasses
        Klass klass1 = new Klass("BP1");
        Klass klass2 = new Klass("BP2");

        //Generate Actual Jobs
        ActualJob actualJob1 = new ActualJob("Software Developer", "Write softwares");
        ActualJob actualJob2 = new ActualJob("Test Writer", "Write tests");

        //Make connections
        klass1.addStudent(student1);
        klass1.addStudent(student2);
        klass1.addStudent(student3);
        klass1.addStudent(student4);
        klass1.addStudent(student5);
        klass2.addStudent(student6);
        klass2.addStudent(student7);
        klass2.addStudent(student8);
        klass2.addStudent(student9);

        workPlace1.addStudent(student1);
        workPlace1.addStudent(student2);
        workPlace1.addStudent(student3);
        workPlace2.addStudent(student4);
        workPlace2.addStudent(student5);
        workPlace3.addStudent(student6);
        workPlace3.addStudent(student7);

        workPlace1.addActualJob(actualJob1);
        workPlace2.addActualJob(actualJob2);

        //Persist
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(school1);

        em.persist(klass1);
        em.persist(klass2);

        em.persist(actualJob1);
        em.persist(actualJob2);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(student7);
        em.persist(student8);
        em.persist(student9);

        em.persist(workPlace1);
        em.persist(workPlace2);
        em.persist(workPlace3);

        transaction.commit();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookPU");
        EntityManager em = emf.createEntityManager();

        populateDbForDemo(em);

        em.close();
        emf.close();
    }
}
