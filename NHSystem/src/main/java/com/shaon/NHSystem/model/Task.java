package com.shaon.NHSystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String starttime;
    @NotEmpty
    private String stoptime;
    @NotEmpty
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Task() {
    }

    public Task(String date, String starttime, String stoptime, String description) {
        this.date = date;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.description = description;
    }

    public Task(String date, String starttime, String stoptime, String description, User user) {
        this.date = date;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.description = description;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStoptime() {
        return stoptime;
    }

    public void setStoptime(String stoptime) {
        this.stoptime = stoptime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
