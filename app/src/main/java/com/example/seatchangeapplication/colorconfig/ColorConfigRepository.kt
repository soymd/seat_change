package com.example.seatchangeapplication.colorconfig

class ColorConfigRepository: IColorConfigRepository {
    override fun get(): List<ColorConfigModel> {
        return listOf();
    }
    override fun put(seatChangeModelList: List<ColorConfigModel>): Int {
        return 0;
    }
    override fun post(seatChangeModelList: List<ColorConfigModel>): Int {
        return 0;
    }
    override fun delete(seatChangeModelList: List<ColorConfigModel>): Int {
        return 0;
    }

}