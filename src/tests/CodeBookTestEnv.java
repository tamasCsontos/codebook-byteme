

import com.codecool.codebook.model.Klass;
import com.codecool.codebook.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * This is a test environment for query testin
 * This is only for filling the db up
 */
public class CodeBookTestEnv {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codebookTestPU");
        EntityManager em = emf.createEntityManager();




        //creating class
        Klass newklass = new Klass("klass");
        Klass newklass2 = new Klass("klass2");

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
    }

}
