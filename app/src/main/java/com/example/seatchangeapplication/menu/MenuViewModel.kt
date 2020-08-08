package com.example.seatchangeapplication.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {
    val callSeatChangeEvent = MutableLiveData<Void>()
    val callColorConfigEvent = MutableLiveData<Void>()
    val callProjectConfigEvent = MutableLiveData<Void>()

    fun callSeatChange() {
        callSeatChangeEvent.value = null
    }

    fun callColorConfig() {
        callColorConfigEvent.value = null
    }

    fun callProjectConfig() {
        callProjectConfigEvent.value = null
    }
}