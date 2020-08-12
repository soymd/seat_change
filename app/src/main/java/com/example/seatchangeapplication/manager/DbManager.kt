package com.example.seatchangeapplication.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.seatchangeapplication.Const
import com.example.seatchangeapplication.SeatChangeSQLiteOpenHelper
import com.example.seatchangeapplication.colorconfig.ColorConfigModel
import com.example.seatchangeapplication.projectconfig.ProjectConfigModel
import com.example.seatchangeapplication.seatchange.SeatChangeModel

/**
 * DB操作機能を保持するクラス
 */
class DbManager(context: Context) {

    private var mDb: SQLiteDatabase

    init {
        var mDbHelper = SeatChangeSQLiteOpenHelper(context, Const.DB_NAME, null,1)
        mDb = mDbHelper.writableDatabase
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
    fun deleteProjectColorModels(): Int {
        return 0
    }

}