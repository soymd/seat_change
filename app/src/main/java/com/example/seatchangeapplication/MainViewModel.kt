package com.example.seatchangeapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {

    private val _callMenuEvent = MutableLiveData<Boolean>(true)
    val callMenuEvent: LiveData<Boolean> = _callMenuEvent

    fun callMenu() {
        var tmp = _callMenuEvent.value ?: true
        _callMenuEvent.value = !tmp
    }

    fun countGreeting(): Int {
        return repository.mockOrNot().count()
    }
}