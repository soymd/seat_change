package com.example.seatchangeapplication.seatchange

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
}