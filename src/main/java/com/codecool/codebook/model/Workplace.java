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
    private String desc;

    @OneToMany(mappedBy = "workplaceid")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "workplace")
    private Set<ActualJob> jobs = new HashSet<>();

    public Workplace() {
    }


    public Workplace(String name, String desc, Set<Student> students) {
        this.name = name;
        this.desc = desc;
        this.students = students;
    }



}
