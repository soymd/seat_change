package com.example.seatchangeapplication.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.seatchangeapplication.Const
import com.example.seatchangeapplication.SeatChangeSQLiteOpenHelper
import com.example.seatchangeapplication.colorconfig.ColorConfigModel
import com.example.seatchangeapplication.dto.RelationProjectColor
import com.example.seatchangeapplication.dto.RelationSeatStaff
import com.example.seatchangeapplication.dto.RelationStaffProject
import com.example.seatchangeapplication.projectconfig.ProjectConfigModel
import com.example.seatchangeapplication.seatchange.SeatChangeModel
import javax.inject.Inject

/**
 * DB操作機能を保持するクラス
 */
class DbManager @Inject constructor(context: Context) {

    private var mDb: SQLiteDatabase

    init {
        var dbHelper = SeatChangeSQLiteOpenHelper(context, Const.DB_NAME, null, 1)
        mDb = dbHelper.writableDatabase
    }

    /**
     * 席替画面：get
     */
    fun getSeatStaffModels(): List<SeatChangeModel> {
        var sql = """

        """.trimIndent()

        return listOf()
    }

    /**
     * 案件設定画面：get
     */
    fun getStaffProjectModels(): List<ProjectConfigModel> {
        var sql = """

        """.trimIndent()

        return listOf()
    }

    /**
     * 色設定画面：get
     */
    fun getProjectColorModels(): List<ColorConfigModel> {
        var sql = """

        """.trimIndent()

        return listOf()
    }

    /**
     * 席替画面：put
     */
    fun putSeatStaffModels(seatChangeModelList: List<SeatChangeModel>): Int {

        return 0
    }

    /**
     * 案件設定画面：put
     */
    fun putStaffProjectModels(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0
    }

    /**
     * 色設定画面：put
     */
    fun putProjectColorModels(): Int {
        return 0
    }

    /**
     * 席替画面：post
     */
    fun postSeatStaffModels(seatChangeModelList: List<SeatChangeModel>): Int {
        return 0
    }

    /**
     * 案件設定画面：post
     */
    fun postStaffProjectModels(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0
    }

    /**
     * 色設定画面：post
     */
    fun postProjectColorModels(): Int {
        return 0
    }

    /**
     * 席替画面：delete
     */
    fun deleteSeatStaffModels(seatChangeModelList: List<SeatChangeModel>): Int {
        return 0
    }

    /**
     * 案件設定画面：delete
     */
    fun deleteStaffProjectModels(projectConfigModelList: List<ProjectConfigModel>): Int {
        return 0
    }

    /**
     * 色設定画面：delete
     */
    fun deleteProjectColorModels(colorConfigModelList: List<ColorConfigModel>): Int {
        return 0
    }

    /**
     * 関係性IDからrelation_seat_staffを引き当てる
     */
    private fun getRelationSeatStaff(relationId: Int): RelationSeatStaff? {
        return RelationSeatStaff.from()
    }

    /**
     * 関係性IDからrelation_staff_projectを引き当てる
     */
    private fun getRelationStaffProject(relationId: Int): RelationStaffProject? {
        return RelationStaffProject.from()
    }

    /**
     * 関係性IDからrelation_project_colorを引き当てる
     */
    private fun getRelationProjectColor(relationId: Int): RelationProjectColor? {
        return RelationProjectColor.from()
    }

    private fun <T> doWithTransaction(action: () -> List<T>?): List<T>? {
        // 全件検索などで使用する想定
        return null;
    }

    private fun <T> doWithTransaction(action: (Int) -> T, it: Int): T? {
        // 1件検索などで使用する想定
        return null;
    }

    private fun <T> doWithTransaction(action: (T) -> Int, it: T): Int {
        // 追加, 更新, 削除などで使用する想定
        return 0;
    }
}