package com.example.seatchangeapplication.projectconfig

interface IProjectConfigRepository {
    fun get(): List<ProjectConfigModel>
    fun post(projectConfigModelList: List<ProjectConfigModel>)
}