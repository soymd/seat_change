package com.example.seatchangeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val callProjectConfigEvent = MutableLiveData<Void>()

    fun callMenu() {
        callProjectConfigEvent.value = null
    }


}
