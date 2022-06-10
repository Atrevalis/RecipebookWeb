package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import server.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.repository.NoteRepository;

import java.util.List;
import java.util.Optional;


public class NoteService  {
    @Autowired
private NoteRepository noteRepository;

    public void createNote(Note note) {noteRepository.save(note);}
    public Optional<Note> getRecipe(Integer id){ return noteRepository.findAllById(id);}
}