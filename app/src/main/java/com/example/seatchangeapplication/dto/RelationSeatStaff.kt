package com.example.seatchangeapplication.dto

/**
 * relation_seat_staffテーブルDTO
 */
data class RelationSeatStaff (
    var relationSeatStaffId: Int,
    var seatId: Int,
    var staffId: Int
) {
    companion object {
        /**
         * ファクトリ
         */
        fun getInstance(): RelationSeatStaff {
            return RelationSeatStaff(
                relationSeatStaffId = 0,
                seatId = 0,
                staffId = 0
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