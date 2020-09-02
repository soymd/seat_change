package com.example.seatchangeapplication.dto

/**
 * staffテーブルDTO
 */
data class Staff (
    var staffId: Int,
    var staffName: String
): IDto {
    companion object: IDtoCompanion<Staff> {
        /**
         * ファクトリー
         */
        override fun from(): Staff {
            return Staff(
                staffId = 0,
                staffName = ""
            )
        }
    }
}