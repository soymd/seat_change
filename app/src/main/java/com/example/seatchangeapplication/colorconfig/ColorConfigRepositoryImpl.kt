package com.example.seatchangeapplication.colorconfig

import com.example.seatchangeapplication.dto.Color
import com.example.seatchangeapplication.dto.Project

/**
 * 色設定画面ロジック実装クラス
 */
class ColorConfigRepositoryImpl: IColorConfigRepository {

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

    override fun setModel(relationId: Int, project: Project, color: Color): ColorConfigModel {
        return ColorConfigModel.from()
    }
}