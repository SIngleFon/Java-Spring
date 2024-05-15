package com.example.Seminar_8;

import com.example.Seminar_8.exception.AccountNotFoundException;
import com.example.Seminar_8.model.Visitor;
import com.example.Seminar_8.repository.VisitorRepository;
import com.example.Seminar_8.service.VisitorService;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ServiceWithAnnotationUnityTest {
    @InjectMocks
    private VisitorService service;

    @Mock
    private VisitorRepository repository;

    @Test
    public void addVisitorCorrectTest(){
        Visitor visitor = new Visitor();
        visitor.setId(1L);
        visitor.setAge(15);
        visitor.setName("Georg");
        visitor.setDateVisit(LocalDateTime.now());

        given(repository.findById(visitor.getId())).willReturn(Optional.of(visitor));

        service.getVisitorById(visitor.getId());

        verify(repository).findById(visitor.getId());
    }

    @Test
    public void addVisitorAccountNotFound(){
        // Создаем мок-объект для VisitorRepository
        VisitorRepository visitorRepository = mock(VisitorRepository.class);

        // Создаем экземпляр сервиса, передавая мок-объект в конструктор
        VisitorService visitorService = new VisitorService(visitorRepository);

        // Создаем объект Visitor для добавления
        Visitor visitor = new Visitor();
        visitor.setId(1L);
        visitor.setAge(15);
        visitor.setName("Georg");
        visitor.setDateVisit(LocalDateTime.now());
        // Указываем ожидаемое поведение мок-объекта при вызове метода save
        when(visitorRepository.save(any(Visitor.class))).thenReturn(visitor);

        // Вызываем метод addVisitor из сервиса
        Visitor addedVisitor = visitorService.addVisitor(visitor);

        // Проверяем, что метод save был вызван один раз с корректным аргументом
        verify(visitorRepository, times(1)).save(visitor);
    }
}
