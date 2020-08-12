package com.example.seatchangeapplication.projectconfig

class ProjectConfigRepositoryImpl: IProjectConfigRepository {

    override fun get(): List<ProjectConfigModel> {
        return listOf();
    }

    override fun post(list: List<ProjectConfigModel>): Int {
        return 0;
    }

    override fun put(list: List<ProjectConfigModel>): Int {
        return 0;
    }

    override fun delete(list: List<ProjectConfigModel>): Int {
        return 0;
    }
}