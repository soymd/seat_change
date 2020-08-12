package com.example.seatchangeapplication.colorconfig

class ColorConfigRepository: IColorConfigRepository {
    override fun get(): List<ColorConfigModel> {
        return listOf();
    }
    override fun put(colorConfigModel: List<ColorConfigModel>): Int {
        return 0;
    }
    override fun post(colorConfigModel: List<ColorConfigModel>): Int {
        return 0;
    }
    override fun delete(colorConfigModel: List<ColorConfigModel>): Int {
        return 0;
    }

}