package com.codecool.codebook.sql;

import com.codecool.codebook.model.Student;

import javax.persistence.*;
import java.util.List;

public class Queries {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebooktestPU");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction etr = em.getTransaction();

    public static List getAllStudent(){
        Query query = em.createQuery("SELECT name from Student");

        return query.getResultList();


    }

    public static List getAllWorkplace(){
        Query query = em.createQuery("SELECT name from Workplace ");

        return query.getResultList();


    }

    public static void addNewStudent(Student student) {
        etr.begin();
        em.persist(student);
        etr.commit();

    }

    public static String getPassword(String email){
        Query query = em.createQuery("SELECT password from Student WHERE email = '" + email + "'");

        return query.getSingleResult().toString();
    }

    public static int getID(String email){
        Query query = em.createQuery("SELECT id from Student WHERE email = '" + email + "'");

        return Integer.parseInt(query.getSingleResult().toString());

    }
}
