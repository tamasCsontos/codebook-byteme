package com.codecool.codebook.sql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Queries {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookPU");
    private static EntityManager em = emf.createEntityManager();

    public static List getAllStudent(){
        Query query = em.createQuery("SELECT name from Student");

        return query.getResultList();


    }

    public static List getAllWorkplace(){
        Query query = em.createQuery("SELECT name from Workplace ");

        return query.getResultList();


    }
}
