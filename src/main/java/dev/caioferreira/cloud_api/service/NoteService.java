package dev.caioferreira.cloud_api.service;

import dev.caioferreira.cloud_api.domain.model.Note;

public interface NoteService {
    Note findById(long id);
    Note create(Note noteToCreate);
    Note update(Note noteToUpdate);
    Note delete(Long id);
}
