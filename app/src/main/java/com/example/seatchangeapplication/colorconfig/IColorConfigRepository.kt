package com.example.seatchangeapplication.colorconfig

/**
 * 色設定画面ロジックIF
 */
interface IColorConfigRepository {
    fun get(): List<ColorConfigModel>
    fun put(seatChangeModelList: List<ColorConfigModel>): Int
    fun post(seatChangeModelList: List<ColorConfigModel>): Int
    fun delete(seatChangeModelList: List<ColorConfigModel>): Int
}