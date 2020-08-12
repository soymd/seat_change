package com.example.seatchangeapplication.dto

/**
 * staffテーブルDTO
 */
data class Staff (
    var staffId: Int,
    var staffName: String
) {
    companion object {
        /**
         * ファクトリー
         */
        fun from(): Staff {
            return Staff(
                staffId = 0,
                staffName = ""
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