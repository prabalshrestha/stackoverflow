package com.et.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private Date dob;
    private Date timestamp;
    private boolean active;
    private String roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private List<Question> question=new ArrayList<Question>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private  List<Answer> answers=new ArrayList<Answer>();

    public User(){
        super();
    }

    public User(Integer userId, String userName, String password, String roles, String email, Date dob, Date timestamp, List<Question> question, List<Answer> answers) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.timestamp = timestamp;
        this.question = question;
        this.answers = answers;
        this.roles=roles;

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
