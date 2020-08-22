package com.example.seatchangeapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {

    private val _callMenuEvent = MutableLiveData<Void>()
    val callMenuEvent: LiveData<Void> = _callMenuEvent

    fun callMenu() {
        _callMenuEvent.value = null
    }

    fun countGreeting(): Int {
        return repository.getGreeting().count()
    }
}