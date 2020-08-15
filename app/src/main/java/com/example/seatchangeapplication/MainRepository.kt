package com.example.seatchangeapplication

import javax.inject.Inject

class MainRepository @Inject constructor() {

    fun getHoge(): String {
        return "hoge"
    }

}