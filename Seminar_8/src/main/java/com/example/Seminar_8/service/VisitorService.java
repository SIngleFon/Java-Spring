package com.example.Seminar_8.service;

import com.example.Seminar_8.aspect.TrackUserAction;
import com.example.Seminar_8.model.Visitor;
import com.example.Seminar_8.repository.VisitorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository repository;


    @TrackUserAction
    public Visitor addVisitor(Visitor visitor){
        return repository.save(visitor);
    }

    @TrackUserAction
    public List<Visitor> getAll(){
        return repository.findAll();
    }

    @TrackUserAction
    public Visitor getVisitorById(Long id){
        return repository.findById(id).orElseThrow(null);
    }
}
