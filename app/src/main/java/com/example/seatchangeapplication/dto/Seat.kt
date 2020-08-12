package com.example.seatchangeapplication.dto

import java.text.FieldPosition

/**
 * seatテーブルDTO
 */
data class Seat (
    var seatId: Int,
    var desk: Int,
    var positionX: Int,
    var positionY: Int
) {
    companion object {
        /**
         * ファクトリー
         */
        fun from(): Seat {
            return Seat(
                seatId = 0,
                desk = 0,
                positionX = 0,
                positionY = 0
            )
        }
    }

    /**
     * データ不正チェック
     */
    fun isValid(): Boolean {
        return true;
    }
}