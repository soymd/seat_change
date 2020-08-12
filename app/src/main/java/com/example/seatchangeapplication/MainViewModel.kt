package com.example.seatchangeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
//    val repositoryImpl: ProjectConfigRepositoryImpl
) : ViewModel() {
    val callMenuEvent = MutableLiveData<Void>()

    fun callMenu() {
        callMenuEvent.value = null
        println("menu called")
    }
}
