package com.example.seatchangeapplication.colorconfig

import com.example.seatchangeapplication.dto.Color
import com.example.seatchangeapplication.dto.Project

/**
 * 色設定画面ロジックIF
 */
interface IColorConfigRepository {
    fun get(): List<ColorConfigModel>
    fun put(seatChangeModelList: List<ColorConfigModel>): Int
    fun post(seatChangeModelList: List<ColorConfigModel>): Int
    fun delete(seatChangeModelList: List<ColorConfigModel>): Int
    fun setModel(relationId: Int, project: Project, color: Color): ColorConfigModel
}