package com.example.Seminar_6.service.implement;

import com.example.Seminar_6.model.Note;
import com.example.Seminar_6.repository.NoteRepository;
import com.example.Seminar_6.service.NoteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NoteServiceImplement implements NoteServiceInterface {
    private final NoteRepository noteRepository;

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNoteById(Long id, Note note) {
        Note noteById = getNoteById(id);
        noteById.setTitle(note.getTitle());
        noteById.setContent(note.getContent());

        return noteRepository.save(noteById);
    }

    @Override
    public void deleteNoteById(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
