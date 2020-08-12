package com.example.seatchangeapplication.dto

/**
 * relation_staff_projectテーブルDTO
 */
data class RelationStaffProject (
    var relationSeatProjectId: Int,
    var seatId: Int,
    var projectId: Int
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}