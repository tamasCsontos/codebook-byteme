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

    @OneToMany(mappedBy = "klassid")
    private Set<Student> students = new HashSet<>();

    public Klass() {
    }

    public Klass(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }


}
