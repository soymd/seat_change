package com.example.seatchangeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val callMenuEvent = MutableLiveData<Void>()

    fun callMenu() {
        callMenuEvent.value = null
        println("menu called")
    }

    fun count(): Int {
        val temp = mainRepository.getHoge()
        return temp.count()
    }
}