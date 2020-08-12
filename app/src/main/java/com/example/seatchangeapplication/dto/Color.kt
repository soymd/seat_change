package com.example.seatchangeapplication.dto

/**
 * colorテーブルDTO
 */
data class Color (
    var colorId: Int,
    var colorName: String,
    var colorValue: String
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}