package com.example.seatchangeapplication.colorconfig

import com.example.seatchangeapplication.IModel
import com.example.seatchangeapplication.IModelCompanion
import com.example.seatchangeapplication.dto.IDto
import com.example.seatchangeapplication.dto.IDtoCompanion
import java.util.*

/**
 * 色設定画面モデル
 */
data class ColorConfigModel(
    var relationProjectColorId: Int,
    var projectName: String,
    var colorName: String,
    var colorValue: String
):IModel {
    companion object: IModelCompanion<ColorConfigModel> {
        /**
         * ファクトリー
         */
        override fun from(): ColorConfigModel {
            return ColorConfigModel(
                relationProjectColorId = 0,
                projectName = "",
                colorName = "",
                colorValue = ""
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