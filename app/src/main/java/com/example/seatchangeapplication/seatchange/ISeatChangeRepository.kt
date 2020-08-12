package com.example.seatchangeapplication.seatchange

interface ISeatChangeRepository {
    fun get(): List<SeatChangeModel>
    fun put(seatChangeModelList: List<SeatChangeModel>): Int
}