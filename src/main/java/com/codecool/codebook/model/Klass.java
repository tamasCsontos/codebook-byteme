package com.codecool.codebook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();

    public Klass() {
    }

    public Klass(String name) {
        this.name = name;
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

    public void addStudent(Student student) {
        student.setKlass(this);
        students.add(student);
    }
}
