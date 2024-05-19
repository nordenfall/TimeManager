package com.example.myapplication.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Event
import com.example.myapplication.utils.TYPE_DATABASE
import com.example.myapplication.utils.TYPE_FIRE
import com.example.myapplication.utils.TYPE_ROOM

class MainViewModel(application:Application):AndroidViewModel(application) {

    val readTest:MutableLiveData<List<Event>> by lazy {
        MutableLiveData<List<Event>>()
    }

    val dbType:MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }
    init {
        readTest.value =
            when(dbType.value){
                TYPE_ROOM -> {
                    listOf<Event>(
                        Event(title = "Event 1", subtitle = "Subtitle for event 1"),
                        Event(title = "Event 2", subtitle = "Subtitle for event 2"),
                        Event(title = "Event 3", subtitle = "Subtitle for event 3"),
                        Event(title = "Event 4", subtitle = "Subtitle for event 4")
                    )
                }
                TYPE_FIRE -> listOf()
                else -> listOf()
            }
    }

    fun initDatabase(type:String){
        dbType.value = type
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }
}