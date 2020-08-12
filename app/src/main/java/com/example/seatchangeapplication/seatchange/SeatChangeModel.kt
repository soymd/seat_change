package com.example.seatchangeapplication.seatchange

/**
 * 席替画面モデル
 */
data class SeatChangeModel(
    var relationSeatStaffId: Int,
    var staffName: String,
    var projectName: String,
    var desk: Int,
    var positionX: Int,
    var positionY: Int,
    var projectColorValue: String
){
    companion object {
        /**
         * ファクトリー
         */
        fun from(): SeatChangeModel {
            return SeatChangeModel(
                relationSeatStaffId = 0,
                staffName = "",
                projectName = "",
                desk = 0,
                positionX = 0,
                positionY = 0,
                projectColorValue = "#ffffff"
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
