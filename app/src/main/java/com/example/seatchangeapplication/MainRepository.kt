package com.example.seatchangeapplication

import javax.inject.Inject

class MainRepository @Inject constructor() {

    fun mockOrNot(): String {
        return "本物"
    }
}
