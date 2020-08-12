package com.example.seatchangeapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.database.getStringOrNull


/**
 * SQLite作成クラス
 */
class SeatChangeSQLiteOpenHelper(
    private val context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(
    context,
    name,
    factory,
    version)
{
    /**
     * 各テーブルのCreate(if not exists時)
     */
    override fun onCreate(db: SQLiteDatabase?) {
        val sql1 = """
            CREATE TABLE if not exists "${Const.SEAT_TBL_NAME}" (
            	"${Const.SEAT_ID}" INTEGER NOT NULL,
            	"${Const.DESK}"	INTEGER NOT NULL,
            	"${Const.POSITION_X}" INTEGER NOT NULL,
            	"${Const.POSITION_Y}" INTEGER NOT NULL,
            	PRIMARY KEY("${Const.SEAT_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        val sql2 = """
            CREATE TABLE if not exists "${Const.STAFF_TBL_NAME}" (
            	"${Const.STAFF_ID}" INTEGER NOT NULL,
            	"${Const.STAFF_NAME}" TEXT NOT NULL,
            	PRIMARY KEY("${Const.STAFF_ID}")
            );
        """.trimIndent()

        val sql3 = """
            CREATE TABLE if not exists "${Const.PROJECT_TBL_NAME}" (
                "${Const.PROJECT_ID}" INTEGER NOT NULL,
                "${Const.PROJECT_TBL_NAME}"	TEXT NOT NULL,
                PRIMARY KEY("${Const.PROJECT_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        val sql4 = """
            CREATE TABLE if not exists "${Const.COLOR_TBL_NAME}" (
            	"${Const.COLOR_ID}"	INTEGER NOT NULL,
            	"${Const.COLOR_NAME}" TEXT NOT NULL,
            	"${Const.COLOR_VALUE}" TEXT NOT NULL,
            	PRIMARY KEY("${Const.COLOR_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        val sql5 = """
            CREATE TABLE if not exists "${Const.RELATION_SEAT_STAFF_TBL_NAME}" (
            	"${Const.RELATION_SEAT_STAFF_ID}" INTEGER NOT NULL,
            	"${Const.SEAT_ID}" INTEGER NOT NULL,
            	"${Const.STAFF_ID}" INTEGER NOT NULL,
            	PRIMARY KEY("${Const.RELATION_SEAT_STAFF_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        val sql6 = """
            CREATE TABLE if not exists "${Const.RELATION_STAFF_PROJECT_TBL_NAME}" (
            	"${Const.RELATION_STAFF_PROJECT_ID}"	INTEGER NOT NULL,
            	"${Const.STAFF_ID}"	INTEGER NOT NULL,
            	"${Const.PROJECT_ID}" INTEGER NOT NULL,
            	PRIMARY KEY("${Const.RELATION_STAFF_PROJECT_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        val sql7 = """
            CREATE TABLE if not exists "${Const.RELATION_PROJECT_COLOR_TBL_NAME}" (
            	"${Const.RELATION_PROJECT_COLOR_ID}" INTEGER NOT NULL,
            	"${Const.PROJECT_ID}" INTEGER NOT NULL,
            	"${Const.COLOR_ID}"	INTEGER NOT NULL,
            	PRIMARY KEY("${Const.RELATION_PROJECT_COLOR_ID}" AUTOINCREMENT)
            );
        """.trimIndent()

        db?.execSQL(sql1)
        db?.execSQL(sql2)
        db?.execSQL(sql3)
        db?.execSQL(sql4)
        db?.execSQL(sql5)
        db?.execSQL(sql6)
        db?.execSQL(sql7)
    }

    /**
     * DBのバージョンアップ時
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun sample() {
        var dbHelper = SeatChangeSQLiteOpenHelper(
            context = context,
            name = Const.DB_NAME,
            factory = null,
            version = 1
        )

        var db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put("staff_name", "smkw")
        db.insertOrThrow("staff", null, values)

        val sql = """
            SELECT * FROM staff;
        """.trimIndent()

        var cursor = db.rawQuery(sql, null)

        if (cursor.count > 0) {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                var str1 = cursor.getStringOrNull(0)
                var str2 = cursor.getStringOrNull(1)
                var str3 = cursor.getStringOrNull(2)
                cursor.moveToNext()
            }
        }
    }

}