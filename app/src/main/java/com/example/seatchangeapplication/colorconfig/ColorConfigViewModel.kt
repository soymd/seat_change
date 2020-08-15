package com.example.seatchangeapplication.colorconfig

import javax.inject.Inject

class ColorConfigViewModel @Inject constructor(
    private val colorConfigRepositoryImpl: ColorConfigRepositoryImpl
) {
    fun getColorList(): List<ColorConfigModel> {
        //return colorConfigRepositoryImpl.get()
        val model = ColorConfigModel.from()
        model.projectName = "fake"

        colorConfigRepositoryImpl.get()


        return listOf(model)
    }
}