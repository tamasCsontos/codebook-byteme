package com.codecool.codebook.model;


import com.codecool.codebook.Location;

import javax.persistence.*;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Location location;

    public School(){}

    public School( Location location) {
        this.location = location;
    }
}
