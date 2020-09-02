package com.example.seatchangeapplication.seatchange

import com.example.seatchangeapplication.IModel
import com.example.seatchangeapplication.IModelCompanion

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
): IModel {
    companion object: IModelCompanion<SeatChangeModel> {
        /**
         * ファクトリー
         */
        override fun from(): SeatChangeModel {
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
    override fun isValid(): Boolean {
        return true;
    }
}
