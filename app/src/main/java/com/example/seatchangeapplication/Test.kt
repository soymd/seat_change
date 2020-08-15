package com.example.seatchangeapplication

import javax.inject.Inject

class Test @Inject constructor(
    private val item: TestItem
){
    var id: Int = 1
}