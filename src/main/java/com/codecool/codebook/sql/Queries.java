package com.codecool.codebook.sql;

import com.codecool.codebook.model.Student;

import javax.persistence.*;
import java.util.List;

public class Queries {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookPU");
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
}
