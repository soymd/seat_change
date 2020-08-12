package com.example.seatchangeapplication.colorconfig

interface IColorConfigRepository {
    fun get(): List<ColorConfigModel>
    fun put(seatChangeModelList: List<ColorConfigModel>): Int
    fun post(seatChangeModelList: List<ColorConfigModel>): Int
    fun delete(seatChangeModelList: List<ColorConfigModel>): Int
}