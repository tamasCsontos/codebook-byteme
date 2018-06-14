

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
        Student std1 =  new Student("john", "asd@gmil.com", "pwd");
        Student std2 =  new Student("john", "asd@gmil.com", "pwd");
        Student std3 =  new Student("john", "asd@gmil.com", "pwd");
        Student std4 =  new Student("john", "asd@gmil.com", "pwd");

        //adding students to class
        newklass.addStudent(std1);
        newklass.addStudent(std2);
        newklass2.addStudent(std3);
        newklass2.addStudent(std3);

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
