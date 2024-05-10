package com.example.Seminar_8.repository;

import com.example.Seminar_8.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Optional<Visitor> findById(Long id);
}
