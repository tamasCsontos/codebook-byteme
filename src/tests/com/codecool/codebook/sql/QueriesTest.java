package com.codecool.codebook.sql;

import com.codecool.codebook.model.Klass;
import com.codecool.codebook.model.Student;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

public class QueriesTest {

    @Test
    public void getAllStudentInfo() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookTestPU");
        EntityManager em = emf.createEntityManager();

        //manual datas
        Klass newklass = new Klass("klass");
        Klass newklass2 = new Klass("klass2");


        //creating students
        Student std1 =  new Student("john", "asd3@gmil.com", "p4wd");
        Student std2 =  new Student("john1", "as2d@gmil.com", "p3wd");
        Student std3 =  new Student("john2", "asdw@gmil.com", "p2wd");
        Student std4 =  new Student("john3", "asd3@gmil.com", "p1wd");

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

        em.close();
        emf.close();


        List list = Queries.getAllStudentInfo();

        List students = new ArrayList();
        for (Object obj: newklass.getStudents()) {
            students.add(obj);
        }
        for (Object obj: newklass2.getStudents()) {
            students.add(obj);
        }
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(students.toArray()));

        for (int i = 0; i < list.size() ; i++) {
            assertEquals(list.get(i).toString(), students.get(i).toString() );
        }

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