package com.example.seatchangeapplication.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.seatchangeapplication.Const
import com.example.seatchangeapplication.SeatChangeSQLiteOpenHelper
import com.example.seatchangeapplication.projectconfig.ProjectConfigModel

class DbManager(context: Context) {

    private var mDb: SQLiteDatabase

    init {
        var mDbHelper = SeatChangeSQLiteOpenHelper(context, Const.DB_NAME, null,1)
        mDb = mDbHelper.writableDatabase
    }

    fun getStaffProjectModels(): List<ProjectConfigModel> {
        var sql = """
            
        """.trimIndent()

        return listOf()
    }

}