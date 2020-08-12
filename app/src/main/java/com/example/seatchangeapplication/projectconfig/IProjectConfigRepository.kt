package com.example.seatchangeapplication.projectconfig

/**
 * 案件設定画面ロジックIF
 */
interface IProjectConfigRepository {
    fun get(): List<ProjectConfigModel>
    fun post(projectConfigModelList: List<ProjectConfigModel>): Int
    fun put(projectConfigModelList: List<ProjectConfigModel>): Int
    fun delete(projectConfigModelList: List<ProjectConfigModel>): Int
}