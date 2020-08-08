package com.example.seatchangeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val callMenuEvent = MutableLiveData<Void>()

    fun callMenu() {
        callMenuEvent.value = null
    }


}
