package com.codecool.codebook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    //TODO
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
