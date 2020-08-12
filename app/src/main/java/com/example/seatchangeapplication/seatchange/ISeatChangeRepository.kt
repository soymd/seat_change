package com.example.seatchangeapplication.seatchange

/**
 * 席替画面ロジックIF
 */
interface ISeatChangeRepository {
    fun get(): List<SeatChangeModel>
    fun put(seatChangeModelList: List<SeatChangeModel>): Int
}