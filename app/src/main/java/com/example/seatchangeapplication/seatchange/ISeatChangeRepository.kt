package com.example.seatchangeapplication.seatchange

import com.example.seatchangeapplication.dto.Seat
import com.example.seatchangeapplication.dto.Staff

/**
 * 席替画面ロジックIF
 */
interface ISeatChangeRepository {
    fun get(): List<SeatChangeModel>
    fun put(seatChangeModelList: List<SeatChangeModel>): Int
    fun setModel(relationId: Int, seat: Seat, staff: Staff): SeatChangeModel
}