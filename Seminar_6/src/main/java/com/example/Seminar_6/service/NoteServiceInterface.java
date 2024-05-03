package com.example.Seminar_6.service;

import com.example.Seminar_6.model.Note;

import java.util.List;

public interface NoteServiceInterface {
    Note addNote(Note note); //Добавление заметки
    List<Note> getNotes(); //ПОлучение всех заметок
    Note getNoteById(Long id); //Получить заметку по айди
    Note updateNoteById(Long id, Note note); //Редактировать заметку по айди
    void deleteNoteById(Long id); //Удалить заметку по айди
}
