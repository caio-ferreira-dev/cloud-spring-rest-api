package dev.caioferreira.cloud_api.domain.repository;

import dev.caioferreira.cloud_api.domain.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
