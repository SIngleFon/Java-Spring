package com.example.Seminar_8.controller;

import com.example.Seminar_8.model.Visitor;
import com.example.Seminar_8.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visitor")
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService service;

    @GetMapping
    public ResponseEntity<List<Visitor>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Visitor> createNote(@RequestBody Visitor visitor){
        return new ResponseEntity<>(service.addVisitor(visitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getNoteById(@PathVariable("id") Long id){
        Visitor visitorById;
        try {
            visitorById = service.getVisitorById(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Visitor());
        }
        return new ResponseEntity<>(visitorById, HttpStatus.OK);
    }
}
