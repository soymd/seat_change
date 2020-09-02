package com.example.seatchangeapplication.dto

/**
 * seatテーブルDTO
 */
data class Seat (
    var seatId: Int,
    var desk: Int,
    var positionX: Int,
    var positionY: Int
): IDto {
    companion object: IDtoCompanion<Seat> {
        /**
         * ファクトリー
         */
        override fun from(): Seat {
            return Seat(
                seatId = 0,
                desk = 0,
                positionX = 0,
                positionY = 0
            )
        }
    }
}