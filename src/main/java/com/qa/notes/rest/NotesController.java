package com.qa.notes.rest;

import com.qa.notes.models.Note;
import com.qa.notes.repository.NotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class NotesController {

    private NotesRepository repository;

    NotesController(NotesRepository notesRepository){
        this.repository = notesRepository;
    }

    @GetMapping(value = "notes")
    public List<Note> listAllNotes(){
        return repository.findAll();
    }

    @PostMapping(value = "addnote")
    public Note addNote(@RequestBody Note note){
        return repository.saveAndFlush(note);
    }

    @GetMapping(value = "notes/{id}")
    public Optional<Note> getNote(@PathVariable Long id){
        return repository.findById(id);
    }

    @DeleteMapping(value = "deletenote/{id}")
    public Note deleteNote(@PathVariable Long id){
        Optional<Note> existing = repository.findById(id);
        repository.delete(existing.get());
        return existing.get();
    }

}
