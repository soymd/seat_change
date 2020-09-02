package com.example.seatchangeapplication.projectconfig

import com.example.seatchangeapplication.IModel
import com.example.seatchangeapplication.IModelCompanion

/**
 * 案件設定画面モデル
 */
data class ProjectConfigModel(
    var relationStaffProjectId: Int,
    var staffName: String,
    var projectName: String,
    var projectColorValue: String
):IModel {
    companion object:IModelCompanion<ProjectConfigModel> {
        /**
         * ファクトリー
         */
        override fun from(): ProjectConfigModel {
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
    override fun isValid(): Boolean {
        return true;
    }
}
