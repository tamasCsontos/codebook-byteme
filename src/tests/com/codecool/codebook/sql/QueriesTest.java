package com.codecool.codebook.sql;

import com.codecool.codebook.model.Klass;
import com.codecool.codebook.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

public class QueriesTest {
    private static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    @Before
    public void populateTDB() {
        Queries.setEnv("codebookTestPU");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookTestPU");
        EntityManager em = emf.createEntityManager();

        //manual datas
        Klass newklass = new Klass("klass");
        Klass newklass2 = new Klass("klass2");


        //creating students
        Student std1 =  new Student("john", "asd3@gmil.com", "p4wd");
        Student std2 =  new Student("john1", "as2d@gmil.com", "p3wd");
        Student std3 =  new Student("john2", "asdw@gmil.com", "p2wd");
        Student std4 =  new Student("john3", "asd4@gmil.com", "p1wd");

        //adding students to class
        newklass.addStudent(std1);
        newklass.addStudent(std2);
        newklass2.addStudent(std3);
        newklass2.addStudent(std4);



        //adding them to database
        em.getTransaction().begin();
        em.persist(newklass);
        em.persist(newklass2);
        em.persist(std1);
        em.persist(std2);
        em.persist(std3);
        em.persist(std4);
        em.getTransaction().commit();

        //closing entity manager
        em.close();
        emf.close();
    }




    /**
     *  Simple test for getAllStudentInfo function
     *  @return: void
     */
    @Test
    public void getAllStudentInfo() {
        Student std1 =  new Student("john", "asd3@gmil.com", "p4wd");
        Student std2 =  new Student("john1", "as2d@gmil.com", "p3wd");
        Student std3 =  new Student("john2", "asdw@gmil.com", "p2wd");
        Student std4 =  new Student("john3", "asd4@gmil.com", "p1wd");

        List list = Queries.getAllStudentInfo();

        //Cast objects to Student objects
        Student student1 = (Student) list.get(0);
        Student student2 = (Student) list.get(1);
        Student student3 = (Student) list.get(2);
        Student student4 = (Student) list.get(3);

        //test each student with the test data
        assertEquals(std1.getEmail(), student1.getEmail());
        assertEquals(std2.getEmail(), student2.getEmail());
        assertEquals(std3.getEmail(), student3.getEmail());
        assertEquals(std4.getEmail(), student4.getEmail());
    }

    @Test
    public void getAllStudentInKlass() {
    }

    @Test
    public void getWorkplaceForStd() {
    }

    @Test
    public void getKlassForStd() {
    }
}