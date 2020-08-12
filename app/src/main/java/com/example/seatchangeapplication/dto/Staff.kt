package com.example.seatchangeapplication.dto

/**
 * staffテーブルDTO
 */
data class Staff (
    var staffId: Int,
    var staffName: String
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}
