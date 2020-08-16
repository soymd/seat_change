package com.example.seatchangeapplication

import javax.inject.Inject

class MainRepository @Inject constructor() {

    fun getGreeting(): String {
        return "ハロー"
    }
}
