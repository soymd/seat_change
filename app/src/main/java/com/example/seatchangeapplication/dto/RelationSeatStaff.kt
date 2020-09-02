package com.example.seatchangeapplication.dto

/**
 * relation_seat_staffテーブルDTO
 */
data class RelationSeatStaff (
    var relationSeatStaffId: Int,
    var seatId: Int,
    var staffId: Int
): IDto {
    companion object: IDtoCompanion<RelationSeatStaff> {
        /**
         * ファクトリー
         */
        override fun from(): RelationSeatStaff {
            return RelationSeatStaff(
                relationSeatStaffId = 0,
                seatId = 0,
                staffId = 0
            )
        }
    }
}