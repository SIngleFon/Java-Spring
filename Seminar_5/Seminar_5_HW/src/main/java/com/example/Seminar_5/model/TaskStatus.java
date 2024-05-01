package com.example.Seminar_5.model;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TaskStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED;
}

