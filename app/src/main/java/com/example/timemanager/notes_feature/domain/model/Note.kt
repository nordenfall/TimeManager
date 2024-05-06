package com.example.timemanager.notes_feature.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.timemanager.ui.theme.Pink80
import com.example.timemanager.ui.theme.PurpleGrey80

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteCoors = listOf(Pink80, PurpleGrey80, Color.Green)
    }


}
