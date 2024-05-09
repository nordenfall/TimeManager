package com.example.timemanager.notes_feature.domain.use_case

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNotesUseCase: DeleteNotesUseCase
)
