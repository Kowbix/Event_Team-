package com.example.Eventeam.entity;


import jakarta.persistence.*;

@Table(name = "connectdata")
@Entity(name = "connectdata")
public class MatchToTaskToUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Match match;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;

    private boolean status;

    public MatchToTaskToUser() {
    }

    public MatchToTaskToUser(Match match, Task task, User user) {
        this.match = match;
        this.task = task;
        this.user = user;
        this.status = true;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
