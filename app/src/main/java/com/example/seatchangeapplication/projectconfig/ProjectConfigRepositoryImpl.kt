package com.example.seatchangeapplication.projectconfig

import com.example.seatchangeapplication.dto.Project
import com.example.seatchangeapplication.dto.Staff

/**
 * 案件設定画面ロジック実装クラス
 */
class ProjectConfigRepositoryImpl: IProjectConfigRepository {

    override fun get(): List<ProjectConfigModel> {
        return listOf();
    }

    override fun post(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0;
    }

    override fun put(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0;
    }

    override fun delete(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0;
    }

    override fun setModel(relationId: Int, staff: Staff, project: Project): ProjectConfigModel {
        return ProjectConfigModel.from()
    }
}