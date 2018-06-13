package com.codecool.codebook.sql;

import antlr.MismatchedTokenException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
