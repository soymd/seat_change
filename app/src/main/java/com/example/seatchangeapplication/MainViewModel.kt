package com.example.seatchangeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {

    val callMenuEvent = MutableLiveData<Void>()

    fun callMenu() {
        callMenuEvent.value = null
        println("menu called")
    }

    fun countGreeting(): Int {
        return repository.getGreeting().count()
    }
}