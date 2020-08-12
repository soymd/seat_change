package com.example.seatchangeapplication.dto

/**
 * relation_project_colorテーブルDTO
 */
data class RelationProjectColor (
    var relationProjectColorId: Int,
    var projectId: Int,
    var colorId: Int
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}