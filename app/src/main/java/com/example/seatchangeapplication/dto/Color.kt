package com.example.seatchangeapplication.dto

/**
 * colorテーブルDTO
 */
data class Color (
    var colorId: Int,
    var colorName: String,
    var colorValue: String
): IDto {
    companion object: IDtoCompanion<Color> {
        /**
         * ファクトリー
         */
        override fun from(): Color {
            return Color(
                colorId = 0,
                colorName = "",
                colorValue = ""
            )
        }
    }
}