import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    public void newItemAdded(){
        Integer initialLength = Queries.getAllStudentInfo().size();
        Integer necessaryLength = initialLength+1;
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        Queries.addNewStudent(testStudent);
        Integer newLength = Queries.getAllStudentInfo().size();
        Assert.assertEquals(necessaryLength, newLength);
        Queries.deleteStudent("TEST@TEST");
    }

    @Test
    public void addedCorrectStudent(){
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        Queries.addNewStudent(testStudent);
        Student addedStudent = Queries.getStudent("TEST@TEST");
        Assert.assertTrue(addedStudent.equals(testStudent));
        Queries.deleteStudent("TEST@TEST");
    }

}
