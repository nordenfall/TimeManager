package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "days_table")
data class Day(
    @PrimaryKey(autoGenerate = true)
    val dayId:Int = 0,
    @ColumnInfo
    val dayTitle:String,
    @ColumnInfo
    var events:List<Event> = emptyList()
)
