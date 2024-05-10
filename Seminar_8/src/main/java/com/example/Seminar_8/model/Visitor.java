package com.example.Seminar_8.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "visitors")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "dateVisit")
    private LocalDateTime dateVisit;

    public Visitor(){
        dateVisit = LocalDateTime.now();
    }
}
