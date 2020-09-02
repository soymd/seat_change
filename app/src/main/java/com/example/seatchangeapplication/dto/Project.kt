package com.example.seatchangeapplication.dto

/**
 * projectテーブルDTO
 */
data class Project (
    var projectId: Int,
    var projectName: Int
): IDto {
    companion object: IDtoCompanion<Project> {
        /**
         * ファクトリー
         */
        override fun from(): Project {
            return Project(
                projectId = 0,
                projectName = 0
            )
        }
    }
}