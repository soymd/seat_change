package com.example.seatchangeapplication.dto

/**
 * relation_staff_projectテーブルDTO
 */
data class RelationStaffProject (
    var relationSeatProjectId: Int,
    var seatId: Int,
    var projectId: Int
): IDto {
    companion object: IDtoCompanion<RelationStaffProject> {
        /**
         * ファクトリー
         */
        override fun from(): RelationStaffProject {
            return RelationStaffProject(
                relationSeatProjectId = 0,
                seatId = 0,
                projectId = 0
            )
        }
    }
}