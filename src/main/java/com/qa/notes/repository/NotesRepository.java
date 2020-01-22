package com.qa.notes.repository;

import com.qa.notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository
        extends JpaRepository<Note, Long> {
}

