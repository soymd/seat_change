package com.example.seatchangeapplication.dto

/**
 * relation_seat_staffテーブルDTO
 */
data class RelationSeatStaff (
    var relationSeatStaffId: Int,
    var seatId: Int,
    var staffId: Int
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}