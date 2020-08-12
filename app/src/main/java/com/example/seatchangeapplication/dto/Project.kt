package com.example.seatchangeapplication.dto

/**
 * projectテーブルDTO
 */
data class Project (
    var projectId: Int,
    var projectName: Int
): IDto {

    /**
     * データ不正チェック
     */
    override fun isValid(): Boolean {
        return true;
    }
}