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

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookPU");
        EntityManager em = emf.createEntityManager();

        populateDb(em);

        em.close();
        emf.close();
    }
}
