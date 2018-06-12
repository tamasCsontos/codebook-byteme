package com.codecool.codebook.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;
    private String WorkplaceFeedback;
    private String phonenumber;

    @ManyToOne
    private Workplace workplaceid;

    @ManyToOne
    private Klass klassid;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private long age;


    public Student() {
    }

    public Student(String name, String email, String workplaceFeedback, Workplace workplaceid, Klass klassid, Date dateOfBirth, String phonenumber) {
        this.name = name;
        this.email = email;
        WorkplaceFeedback = workplaceFeedback;
        this.workplaceid = workplaceid;
        this.klassid = klassid;
        this.dateOfBirth = dateOfBirth;
        this.phonenumber = phonenumber;
        this.age = (Calendar.getInstance().getTimeInMillis() - dateOfBirth.getTime())
                / (60L * 60L * 1000L * 365L * 24L);
    }

}
