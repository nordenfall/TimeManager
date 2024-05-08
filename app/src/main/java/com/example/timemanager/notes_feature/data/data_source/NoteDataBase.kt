package com.example.timemanager.notes_feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timemanager.notes_feature.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase:RoomDatabase() {

    abstract val noteDao: NoteDao
}