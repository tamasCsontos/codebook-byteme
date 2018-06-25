/*package com.codecool.codebook.sql;

import com.codecool.codebook.model.Student;
import com.codecool.codebook.sql.Queries;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Before
    public void setEnvironment(){
        Queries.setEnv("codebooktestPU");
    }

    @Test
    public void newItemAdded(){
        Integer initialLength = Queries.getAllStudentInfo().size();
        Integer necessaryLength = initialLength+1;
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        Queries.addNewStudent(testStudent);
        Integer newLength = Queries.getAllStudentInfo().size();
        Assert.assertEquals(necessaryLength, newLength);
    }

    @Test
    public void addedCorrectStudent(){
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        Queries.addNewStudent(testStudent);
        Student addedStudent = Queries.getStudent("TEST@TEST");
        Assert.assertTrue(addedStudent.equals(testStudent));
    }

    @AfterEach
    public void deleteTestStudent(){
        Queries.deleteStudent("TEST@TEST");
    }

}*/
