package dev.caioferreira.cloud_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.caioferreira.cloud_api.domain.model.Note;
import dev.caioferreira.cloud_api.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        var note = noteService.findById(id);
        return ResponseEntity.ok(note);
    }

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note noteToCreate) {
        var noteCreated = noteService.create(noteToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(noteCreated.getId()).toUri();
        return ResponseEntity.created(location).body(noteCreated);
    }

    @PutMapping
    public ResponseEntity<Note> update(@RequestBody Note noteToUpdate) {
        var updatedNote = noteService.update(noteToUpdate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedNote.getId()).toUri();
        return ResponseEntity.created(location).body(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> delete(@PathVariable Long id) {
        var noteDeleted = noteService.delete(id);
        
        return ResponseEntity.ok(noteDeleted);
    }
}
