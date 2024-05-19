package com.example.myapplication.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Update
import com.example.myapplication.model.Day
import com.example.myapplication.model.Event

@Dao
interface DayDao {
    @Query("SELECT * FROM days_table ORDER BY dayTitle ASC")
    fun getAllDays(): LiveData<List<Day>>

    @Insert
    suspend fun insertDay(day: Day)

    @Update
    suspend fun updateDay(day: Day)

    @Delete
    suspend fun deleteDay(day: Day)

    @Transaction
    @Query("SELECT * FROM days_table")
    fun getAllDaysWithEvents(): LiveData<List<DayWithEvents>>
}

@Entity(primaryKeys = ["id"])
data class DayWithEvents(
    @Embedded
    val day: Day,
    @Relation(parentColumn = "id", entityColumn = "dayId")
    val events: List<Event>
)