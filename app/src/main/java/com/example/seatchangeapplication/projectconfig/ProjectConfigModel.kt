package com.example.seatchangeapplication.projectconfig

data class ProjectConfigModel(
    var relationStaffProjectId: Int,
    var staffName: String,
    var projectName: String,
    var projectColorValue: String
) {
    companion object {
        fun getInstance(): ProjectConfigModel {
            return ProjectConfigModel(
                relationStaffProjectId = 0,
                staffName = "",
                projectName = "",
                projectColorValue = ""
            )
        }
    }
}