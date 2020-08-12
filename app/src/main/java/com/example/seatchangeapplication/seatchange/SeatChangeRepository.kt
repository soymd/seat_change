package com.example.seatchangeapplication.seatchange

class SeatChangeRepository: ISeatChangeRepository {

    override fun get(): List<SeatChangeModel> {
        return listOf();
    }

    override fun put(seatChangeModelList: List<SeatChangeModel>): Int {
        return 0;
    }



}