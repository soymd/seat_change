package com.example.seatchangeapplication.colorconfig

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ColorConfigViewModel @Inject constructor(
    private val colorConfigRepositoryImpl: ColorConfigRepositoryImpl
) : ViewModel() {
    fun getColorList(): List<ColorConfigModel> {
        //return colorConfigRepositoryImpl.get()
        val model = ColorConfigModel.from()
        model.projectName = "fake"

        colorConfigRepositoryImpl.get()

        return listOf(model)
    }
}