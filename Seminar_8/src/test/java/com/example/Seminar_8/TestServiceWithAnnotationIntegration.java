package com.example.Seminar_8;

import com.example.Seminar_8.model.Visitor;
import com.example.Seminar_8.repository.VisitorRepository;
import com.example.Seminar_8.service.VisitorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;



@SpringBootTest
public class TestServiceWithAnnotationIntegration {
    @Autowired
    private VisitorService service;

    @MockBean
    private VisitorRepository repository;


    @Test
    public void addVisitorAccountNotFound(){
        // Создаем мок-объект для VisitorRepository
        Visitor visitor = new Visitor();
        visitor.setId(1L);
        visitor.setAge(15);
        visitor.setName("Georg");
        visitor.setDateVisit(LocalDateTime.now());

        given(repository.findById(visitor.getId())).willReturn(Optional.of(visitor));

        service.getVisitorById(visitor.getId());

        verify(repository).findById(visitor.getId());
    }
}
