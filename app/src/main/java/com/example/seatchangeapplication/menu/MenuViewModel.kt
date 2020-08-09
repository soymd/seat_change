package com.example.seatchangeapplication.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seatchangeapplication.FragmentType

class MenuViewModel : ViewModel() {
    val callFragmentEvent = MutableLiveData<FragmentType>()
    val countEvent = MutableLiveData<Int>()

    init {
        countEvent.value = 0
    }

    fun callFragment(type: FragmentType) {
        callFragmentEvent.value = type
        countEvent.value = countEvent.value?.plus(1)
        println("count is ${countEvent.value}")
    }
}