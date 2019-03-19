package com.codecool.codebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;
    private String workplaceFeedback;
    private String phonenumber;

    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Workplace workplace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klass_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Klass klass;

    @OneToMany(mappedBy = "senderStudent")
    private Set<Message> sentMessages = new HashSet<>();


    @OneToMany(mappedBy = "receiverStudent")
    private Set<Message> recievedMessages = new HashSet<>();

    public Student() {
    }

//    public Student(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }

    public Student(String name, String email, String workplaceFeedback) {
        this.name = name;
        this.email = email;
        this.workplaceFeedback = workplaceFeedback;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkplaceFeedback() {
        return workplaceFeedback;
    }

    public void setWorkplaceFeedback(String workplaceFeedback) {
        this.workplaceFeedback = workplaceFeedback;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplaceid) {
        this.workplace = workplaceid;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klassid) {
        this.klass = klassid;
    }

    public String getPassword() {
        return password;
    }

    public void addSentMessage(Message message) {
        message.setSenderStudent(this);
        sentMessages.add(message);
    }

    public void addReceivedMessage(Message message) {
        message.setReceiverStudent(this);
        recievedMessages.add(message);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
