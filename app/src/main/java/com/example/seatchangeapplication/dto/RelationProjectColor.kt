package com.example.seatchangeapplication.dto

/**
 * relation_project_colorテーブルDTO
 */
data class RelationProjectColor (
    var relationProjectColorId: Int,
    var projectId: Int,
    var colorId: Int
) {
    companion object {
        /**
         * ファクトリー
         */
        fun getInstance(): RelationProjectColor {
            return RelationProjectColor(
                relationProjectColorId = 0,
                projectId = 0,
                colorId = 0
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