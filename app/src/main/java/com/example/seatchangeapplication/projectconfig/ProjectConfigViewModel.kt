package com.example.seatchangeapplication.projectconfig

import javax.inject.Inject

class ProjectConfigViewModel @Inject constructor(
    private val projectConfigRepositoryImpl: ProjectConfigRepositoryImpl
) {
    fun test(): String {
        return projectConfigRepositoryImpl.get().toString()
    }
}