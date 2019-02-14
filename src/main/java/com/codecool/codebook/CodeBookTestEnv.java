package com.codecool.codebook;

import com.codecool.codebook.model.Klass;
import com.codecool.codebook.model.Student;
import com.codecool.codebook.model.Workplace;

import javax.persistence.EntityManager;

/**
 * This is a test environment for query testin
 * This is only for filling the db up
 */
public class CodeBookTestEnv {

    public static void createDB(EntityManager em) {

        //creating class
        Klass newklass = new Klass("klass");
        Klass newklass2 = new Klass("klass2");
        Workplace workplace = new Workplace("Pedigre", "Dogfood");


        //creating students
        Student std1 =  new Student("john1", "as44d@gmil.com", "pw2d");
        Student std2 =  new Student("john2", "as23d@gmil.com", "p5wd");
        Student std3 =  new Student("john3", "as3d@gmil.com", "pw3d");
        Student std4 =  new Student("john4", "as321d@gmil.com", "pw4d");

        //adding students to class
        newklass.addStudent(std1);
        newklass.addStudent(std2);
        newklass2.addStudent(std3);
        newklass2.addStudent(std4);

        workplace.addStudent(std4);

        //adding them to database
        em.getTransaction().begin();
        em.persist(newklass);
        em.persist(newklass2);
        em.persist(std1);
        em.persist(std2);
        em.persist(std3);
        em.persist(std4);
        em.persist(workplace);
        em.getTransaction().commit();

    }

}
