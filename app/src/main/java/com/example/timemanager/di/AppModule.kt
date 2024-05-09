package com.example.timemanager.di

import android.app.Application
import androidx.room.Room
import com.example.timemanager.notes_feature.data.data_source.NoteDataBase
import com.example.timemanager.notes_feature.data.repository.NoteRepositoryImplementation
import com.example.timemanager.notes_feature.domain.repository.NoteRepository
import com.example.timemanager.notes_feature.domain.use_case.DeleteNotesUseCase
import com.example.timemanager.notes_feature.domain.use_case.GetNotesUseCase
import com.example.timemanager.notes_feature.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDataBase):NoteRepository{
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository:NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNotesUseCase = DeleteNotesUseCase(repository)
        )
    }

}