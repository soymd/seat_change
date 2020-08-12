package com.example.seatchangeapplication.seatchange

import com.example.seatchangeapplication.dto.Seat
import com.example.seatchangeapplication.dto.Staff

/**
 * 席替画面ロジック実装クラス
 */
class SeatChangeRepositoryImpl: ISeatChangeRepository {

    override fun get(): List<SeatChangeModel> {
        return listOf();
    }

    override fun put(seatChangeModelList: List<SeatChangeModel>): Int {
        return 0;
    }

    override fun setModel(relationId: Int, seat: Seat, staff: Staff): SeatChangeModel {
        return SeatChangeModel.from()
    }
}