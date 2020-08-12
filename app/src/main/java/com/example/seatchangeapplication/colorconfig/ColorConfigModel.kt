package com.example.seatchangeapplication.colorconfig

data class ColorConfigModel(
    var relationProjectColorId: Int,
    var projectName: String,
    var colorName: String,
    var colorValue: String
) {
    companion object {
        fun getInstance(): ColorConfigModel {
            return ColorConfigModel(
                relationProjectColorId = 0,
                projectName = "",
                colorName = "",
                colorValue = ""
            )
        }
    }

    fun isValid(): Boolean {
        return true;
    }
}