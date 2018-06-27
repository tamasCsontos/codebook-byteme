package com.codecool.codebook.sql;

import com.codecool.codebook.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Persistence;

public class RegistrationTest {

    Queries queries = new Queries(Persistence.createEntityManagerFactory("codebooktestPU"));

    @Test
    public void newItemAdded(){
        Integer initialLength = queries.getAllStudentInfo().size();
        Integer necessaryLength = initialLength+1;
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        queries.addNewStudent(testStudent);
        Integer newLength = queries.getAllStudentInfo().size();
        Assert.assertEquals(necessaryLength, newLength);
    }

    @Test
    public void addedCorrectStudent(){
        Student testStudent = new Student("TEST", "TEST@TEST", "TEST");
        queries.addNewStudent(testStudent);
        Student addedStudent = queries.getStudent("TEST@TEST");
        Assert.assertTrue(addedStudent.equals(testStudent));
    }

    @AfterEach
    public void deleteTestStudent(){
        queries.deleteStudent("TEST@TEST");
    }

}
