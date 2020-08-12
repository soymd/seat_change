package com.example.seatchangeapplication.colorconfig

/**
 * 色設定画面モデル
 */
data class ColorConfigModel(
    var relationProjectColorId: Int,
    var projectName: String,
    var colorName: String,
    var colorValue: String
) {
    companion object {
        /**
         * ファクトリー
         */
        fun from(): ColorConfigModel {
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
    fun isValid(): Boolean {
        return true;
    }
}