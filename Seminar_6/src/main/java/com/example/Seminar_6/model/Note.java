package com.example.Seminar_6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    private LocalDateTime created;

    public Note(@NonNull String title, @NonNull String content){
        this.content = content;
        this.title = title;
        created = LocalDateTime.now();
    }

    public Note(){
        created = LocalDateTime.now();
    }
}
