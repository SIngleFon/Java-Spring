package com.example.Seminar_5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    @Enumerated
    private TaskStatus status;
    @Column
    private LocalDateTime created;

    public Task(@NonNull String name){
        this.name = name;
        this.status = TaskStatus.NOT_STARTED;
        this.created = LocalDateTime.now();
    }
    public Task(){
        this.status = TaskStatus.NOT_STARTED;
        this.created = LocalDateTime.now();
    }

}

