package com.example.Course.Registration.System.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String trainer;
    private int durationTime;


    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
