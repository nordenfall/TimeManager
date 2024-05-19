package com.example.myapplication.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.database.room.dao.DayDao
import com.example.myapplication.database.room.dao.EventDao
import com.example.myapplication.model.Day
import com.example.myapplication.model.Event

@Database(entities = [Day::class, Event::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dayDao(): DayDao
    abstract fun eventDao():EventDao
}