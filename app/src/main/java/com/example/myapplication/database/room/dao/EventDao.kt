package com.example.myapplication.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.model.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM events_table WHERE dayId = :dayId")
    fun getEventsByDayId(dayId: Int): LiveData<List<Event>>
}