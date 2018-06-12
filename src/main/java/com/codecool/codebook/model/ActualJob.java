package com.codecool.codebook.model;

import javax.persistence.*;

@Entity
public class ActualJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @ManyToOne
    private Workplace workplace;


}
