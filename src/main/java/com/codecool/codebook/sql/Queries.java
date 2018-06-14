package com.codecool.codebook.sql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codecool.codebook.model.Klass;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.model.Workplace;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class Queries {

    private static String dbName = "codebookPU";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbName);
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction etr = em.getTransaction();

    public static void setDbName(String dbName) {
        Queries.dbName = dbName;
    }

    /**
     * Simple select query
     * @return List
     */
    public static List getAllStudentInfo(){
        Query query = em.createQuery("SELECT s FROM Student s");

        return query.getResultList();
    }




    /**
     *  Returns all the students from a specific klass
     *  @params: klass_id : long
     *  @return: Set : Student obj
     */
    public static Set getAllStudentInKlass(long klassId){
        try {
            Klass klass = em.find(Klass.class, klassId);
            return klass.getStudents();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     *   Returns a specific Workplace name for a student
     *   @param: workplace_id : long
     *   @returtn: String or null on exception
     */
    public static String getWorkplaceForStd(long workplaceId){
        try {
            Workplace workplace = em.find(Workplace.class, workplaceId);
            return workplace.getName();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     *   Returns a specific Klass name for a student
     *   param: klassId
     *   return: String or null on exception
     */
    public static String getKlassForStd(long klassId){
        try {
            Klass klass = em.find(Klass.class, klassId);

            return klass.getName();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        return null;
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

    public static void setEnv(String dbName){
        emf = Persistence.createEntityManagerFactory(dbName);
        em = emf.createEntityManager();
        etr = em.getTransaction();
    }
}
