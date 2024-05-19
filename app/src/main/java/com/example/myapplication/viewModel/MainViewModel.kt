package com.example.myapplication.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Day
import com.example.myapplication.utils.TYPE_FIRE

import com.example.myapplication.utils.TYPE_ROOM


class MainViewModel(application:Application):AndroidViewModel(application) {
    private val context = application

    val readTest:MutableLiveData<List<Day>> by lazy {
        MutableLiveData<List<Day>>()
    }

    val dbType:MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value){
                TYPE_ROOM -> {
                    listOf<Day>(
                        Day(dayTitle = "Понедельник"),
                        Day(dayTitle = "Вторник"),
                        Day(dayTitle = "Среда"),
                        Day(dayTitle = "Четверг"),
                        Day(dayTitle = "Пятница"),
                        Day(dayTitle = "Суббота"),
                        Day(dayTitle = "Воскресенье")

                    )
                }
                TYPE_FIRE -> listOf()
                else -> listOf()
            }
    }


    fun initDataBase(type:String){
        dbType.value = type
    }

}