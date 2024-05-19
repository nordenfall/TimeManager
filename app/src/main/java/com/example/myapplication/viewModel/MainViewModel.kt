package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.myapplication.database.room.AppDatabase
import com.example.myapplication.database.room.dao.DayDao
import com.example.myapplication.database.room.dao.DayWithEvents
import com.example.myapplication.database.room.dao.EventDao
import com.example.myapplication.model.Day
import com.example.myapplication.model.Event
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "app_database"
    ).build()

    private val dayDao: DayDao = db.dayDao()
    private val eventDao: EventDao = db.eventDao()

    val days: LiveData<List<Day>> = db.dayDao().getAllDays()
    val daysWithEvents: LiveData<List<DayWithEvents>> = db.dayDao().getAllDaysWithEvents()

    fun getEventsForDay(dayId: Int): LiveData<List<Event>> {
        return eventDao.getEventsByDayId(dayId)
    }
    init {
        viewModelScope.launch {
            val days = listOf(
                Day(dayTitle = "понедельник"),
                Day(dayTitle = "вторник"),
                Day(dayTitle = "среда"),
                Day(dayTitle = "четверг"),
                Day(dayTitle = "пятница"),
                Day(dayTitle = "суббота"),
                Day(dayTitle = "воскресеньек"),
            )
            days.forEach { day ->
                db.dayDao().insertDay(day)
            }
        }
    }
}


