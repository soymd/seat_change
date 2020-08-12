package com.example.seatchangeapplication.projectconfig

import com.example.seatchangeapplication.dto.Project
import com.example.seatchangeapplication.dto.Staff

/**
 * 案件設定画面ロジックIF
 */
interface IProjectConfigRepository {
    fun get(): List<ProjectConfigModel>
    fun post(projectConfigModelList: List<ProjectConfigModel>): Int
    fun put(projectConfigModelList: List<ProjectConfigModel>): Int
    fun delete(projectConfigModelList: List<ProjectConfigModel>): Int
    fun setModel(relationId: Int, staff: Staff, project: Project): ProjectConfigModel
}