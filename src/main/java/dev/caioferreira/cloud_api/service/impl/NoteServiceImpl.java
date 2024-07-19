package dev.caioferreira.cloud_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dev.caioferreira.cloud_api.domain.model.Note;
import dev.caioferreira.cloud_api.domain.repository.NoteRepository;
import dev.caioferreira.cloud_api.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findById(long id) {
        return noteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Note create(Note noteToCreate) {
        if(noteToCreate.getId() != null && noteRepository.existsById(noteToCreate.getId())) {
            throw new IllegalArgumentException("This note id already exists");
        }
        return noteRepository.save(noteToCreate);
    }

    @Override
    public Note update(Note noteToUpdate) {
        if(noteToUpdate.getId() == null && !noteRepository.existsById(noteToUpdate.getId())) {
            throw new IllegalArgumentException("This note id doesn't exists");
        }
        return noteRepository.save(noteToUpdate);
    }

    @Override
    public Note delete(Long id) {
        Note noteToBeDeleted = noteRepository.findById(id).orElseThrow(NoSuchElementException::new);

        noteRepository.deleteById(id);

        return noteToBeDeleted;
    }
    

}
