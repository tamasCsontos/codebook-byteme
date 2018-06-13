package com.codecool.codebook.sql;

import antlr.MismatchedTokenException;

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


    public static List getAllStudentInfo(){
        Query query = em.createQuery("From Student ");

        return query.getResultList();
    }


    public static String getWorkplaceForStd(long workplaceId){
        try {
            Query query = em.createQuery("SELECT name From Workplace WHERE id = " + workplaceId + " ");
            return query.getSingleResult().toString();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return "";
    }

    public static String getKlassForStd(long klassId){
        try {
            Query query = em.createQuery("SELECT name FROM Klass WHERE id = " + klassId + " ");
            return query.getSingleResult().toString();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        return "";
    }
}
