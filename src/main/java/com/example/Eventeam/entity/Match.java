package com.example.Eventeam.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String matchType;
    private String roboticketId;

    private LocalDate date;

    public Match() {
    }

    public Match(String name, String matchType, String roboticketId, LocalDate date) {
        this.name = name;
        this.matchType = matchType;
        this.roboticketId = roboticketId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getRoboticketId() {
        return roboticketId;
    }

    public void setRoboticketId(String roboticketId) {
        this.roboticketId = roboticketId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matchType='" + matchType + '\'' +
                ", roboticketId='" + roboticketId + '\'' +
                ", date=" + date +
                '}';
    }
}
