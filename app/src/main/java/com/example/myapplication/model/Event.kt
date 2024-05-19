package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val eventId:Int = 0,
    @ColumnInfo
    val eventTitle:String,
    @ColumnInfo
    val subtitle:String
)


