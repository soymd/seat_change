package com.example.seatchangeapplication.dto

/**
 * relation_project_colorテーブルDTO
 */
data class RelationProjectColor (
    var relationProjectColorId: Int,
    var projectId: Int,
    var colorId: Int
): IDto {
    companion object: IDtoCompanion<RelationProjectColor> {
        /**
         * ファクトリー
         */
        override fun from(): RelationProjectColor {
            return RelationProjectColor(
                relationProjectColorId = 0,
                projectId = 0,
                colorId = 0
            )
        }
    }
}