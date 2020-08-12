package com.example.seatchangeapplication.projectconfig

/**
 * 案件設定画面モデル
 */
data class ProjectConfigModel(
    var relationStaffProjectId: Int,
    var staffName: String,
    var projectName: String,
    var projectColorValue: String
) {
    companion object {
        /**
         * ファクトリー
         */
        fun from(): ProjectConfigModel {
            return ProjectConfigModel(
                relationStaffProjectId = 0,
                staffName = "",
                projectName = "",
                projectColorValue = ""
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
