package com.example.seatchangeapplication.dto

/**
 * colorテーブルDTO
 */
data class Color (
    var colorId: Int,
    var colorName: String,
    var colorValue: String
) {
    companion object {
        /**
         * ファクトリー
         */
        fun from(): Color {
            return Color(
                colorId = 0,
                colorName = "",
                colorValue = ""
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