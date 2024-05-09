package com.example.timemanager.notes_feature.domain.use_case

import com.example.timemanager.notes_feature.domain.model.Note
import com.example.timemanager.notes_feature.domain.repository.NoteRepository

class DeleteNotesUseCase(
    private val repository:NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}