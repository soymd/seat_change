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
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}