package com.example.seatchangeapplication.dto

/**
 * relation_staff_projectテーブルDTO
 */
data class RelationStaffProject (
    var relationSeatProjectId: Int,
    var seatId: Int,
    var projectId: Int
) {
    companion object {
        /**
         * ファクトリー
         */
        fun getInstance(): RelationStaffProject {
            return RelationStaffProject(
                relationSeatProjectId = 0,
                seatId = 0,
                projectId = 0
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