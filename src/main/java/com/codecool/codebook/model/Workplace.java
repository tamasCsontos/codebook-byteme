package com.codecool.codebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "workplace")
    private Set<Student> students = new HashSet<>();

//    @OneToMany(mappedBy = "workplace")
//    private Set<ActualJob> jobs = new HashSet<>();

    public Workplace() {
    }

    public Workplace(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void addStudent(Student student) {
        student.setWorkplace(this);
        students.add(student);
    }

    public void addActualJob(ActualJob actualJob) {
        actualJob.setWorkplace(this);
//        jobs.add(actualJob);
    }

//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public Set<ActualJob> getJobs() {
//        return jobs;
//    }
}
