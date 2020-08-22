package com.example.seatchangeapplication.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seatchangeapplication.FragmentType
import javax.inject.Inject

class MenuViewModel @Inject constructor() : ViewModel() {
    val callFragmentEvent = MutableLiveData<FragmentType>()
    val countEvent = MutableLiveData<Int>(0)

    fun callFragment(type: FragmentType) {
        callFragmentEvent.value = type
        countEvent.value = countEvent.value?.plus(1)
    }
}