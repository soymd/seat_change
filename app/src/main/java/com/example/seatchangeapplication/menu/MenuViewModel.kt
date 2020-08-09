package com.example.seatchangeapplication.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seatchangeapplication.FragmentType

class MenuViewModel : ViewModel() {
    val callFragmentEvent = MutableLiveData<FragmentType>()

    fun callFragment(type: FragmentType) {
        callFragmentEvent.value = type
    }
}