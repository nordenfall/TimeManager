package com.example.timemanager.notes_feature.domain.repository

import com.example.timemanager.notes_feature.domain.model.Note
import kotlinx.coroutines.flow.Flow
//потом на этом интерфейсе можно будет плодить репы
interface NoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id:Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}