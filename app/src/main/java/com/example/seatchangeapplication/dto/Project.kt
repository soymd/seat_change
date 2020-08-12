package com.example.seatchangeapplication.dto

/**
 * projectテーブルDTO
 */
data class Project (
    var projectId: Int,
    var projectName: Int
) {
    companion object {
        /**
         * ファクトリー
         */
        fun getInstance(): Project {
            return Project(
                projectId = 0,
                projectName = 0
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