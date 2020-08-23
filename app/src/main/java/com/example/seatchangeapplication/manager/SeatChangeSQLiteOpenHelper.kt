package com.example.seatchangeapplication.manager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.seatchangeapplication.constant.SqlConst
import java.io.*


/**
 * SQLite作成クラス
 */
class SeatChangeSQLiteOpenHelper(
    private val context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(
    context,
    name,
    factory,
    version
) {
    val sql1 = """
        CREATE TABLE if not exists "${SqlConst.SEAT_TBL_NAME}" (
            "${SqlConst.SEAT_ID}" INTEGER NOT NULL,
            "${SqlConst.DESK}"	INTEGER NOT NULL,
            "${SqlConst.POSITION_X}" INTEGER NOT NULL,
            "${SqlConst.POSITION_Y}" INTEGER NOT NULL,
            PRIMARY KEY("${SqlConst.SEAT_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val sql2 = """
        CREATE TABLE if not exists "${SqlConst.STAFF_TBL_NAME}" (
            "${SqlConst.STAFF_ID}" INTEGER NOT NULL,
            "${SqlConst.STAFF_NAME}" TEXT NOT NULL,
            PRIMARY KEY("${SqlConst.STAFF_ID}")
        );
    """.trimIndent()

    val sql3 = """
        CREATE TABLE if not exists "${SqlConst.PROJECT_TBL_NAME}" (
            "${SqlConst.PROJECT_ID}" INTEGER NOT NULL,
            "${SqlConst.PROJECT_NAME}"	TEXT NOT NULL,
            PRIMARY KEY("${SqlConst.PROJECT_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val sql4 = """
        CREATE TABLE if not exists "${SqlConst.COLOR_TBL_NAME}" (
            "${SqlConst.COLOR_ID}"	INTEGER NOT NULL,
            "${SqlConst.COLOR_NAME}" TEXT NOT NULL,
            "${SqlConst.COLOR_VALUE}" TEXT NOT NULL,
            PRIMARY KEY("${SqlConst.COLOR_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val sql5 = """
        CREATE TABLE if not exists "${SqlConst.RELATION_SEAT_STAFF_TBL_NAME}" (
            "${SqlConst.RELATION_SEAT_STAFF_ID}" INTEGER NOT NULL,
            "${SqlConst.SEAT_ID}" INTEGER NOT NULL,
            "${SqlConst.STAFF_ID}" INTEGER NOT NULL,
            PRIMARY KEY("${SqlConst.RELATION_SEAT_STAFF_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val sql6 = """
        CREATE TABLE if not exists "${SqlConst.RELATION_STAFF_PROJECT_TBL_NAME}" (
            "${SqlConst.RELATION_STAFF_PROJECT_ID}"	INTEGER NOT NULL,
            "${SqlConst.STAFF_ID}"	INTEGER NOT NULL,
            "${SqlConst.PROJECT_ID}" INTEGER NOT NULL,
            PRIMARY KEY("${SqlConst.RELATION_STAFF_PROJECT_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val sql7 = """
        CREATE TABLE if not exists "${SqlConst.RELATION_PROJECT_COLOR_TBL_NAME}" (
            "${SqlConst.RELATION_PROJECT_COLOR_ID}" INTEGER NOT NULL,
            "${SqlConst.PROJECT_ID}" INTEGER NOT NULL,
            "${SqlConst.COLOR_ID}"	INTEGER NOT NULL,
            PRIMARY KEY("${SqlConst.RELATION_PROJECT_COLOR_ID}" AUTOINCREMENT)
        );
    """.trimIndent()

    val stubList = listOf(
        "INSERT INTO ${SqlConst.SEAT_TBL_NAME} VALUES(1, 1, 1, 1);",
        "INSERT INTO ${SqlConst.SEAT_TBL_NAME} VALUES(2, 1, 1, 2);",
        "INSERT INTO ${SqlConst.SEAT_TBL_NAME} VALUES(3, 1, 2, 1);",

        "INSERT INTO ${SqlConst.STAFF_TBL_NAME} VALUES(1, 'test一郎');",
        "INSERT INTO ${SqlConst.STAFF_TBL_NAME} VALUES(2, 'test次郎');",
        "INSERT INTO ${SqlConst.STAFF_TBL_NAME} VALUES(3, 'test三郎');",

        "INSERT INTO ${SqlConst.PROJECT_TBL_NAME} VALUES(1, '案件1');",
        "INSERT INTO ${SqlConst.PROJECT_TBL_NAME} VALUES(2, '案件2');",
        "INSERT INTO ${SqlConst.PROJECT_TBL_NAME} VALUES(3, '案件3');",

        "INSERT INTO ${SqlConst.COLOR_TBL_NAME} VALUES(1, '赤', 'ff0000');",
        "INSERT INTO ${SqlConst.COLOR_TBL_NAME} VALUES(2, '緑', '00ff00');",
        "INSERT INTO ${SqlConst.COLOR_TBL_NAME} VALUES(3, '青', '0000ff');",

        "INSERT INTO ${SqlConst.RELATION_SEAT_STAFF_TBL_NAME} VALUES(1, 1, 1);",
        "INSERT INTO ${SqlConst.RELATION_SEAT_STAFF_TBL_NAME} VALUES(2, 2, 2);",
        "INSERT INTO ${SqlConst.RELATION_SEAT_STAFF_TBL_NAME} VALUES(3, 3, 3);",

        "INSERT INTO ${SqlConst.RELATION_STAFF_PROJECT_TBL_NAME} VALUES(1, 1, 1);",
        "INSERT INTO ${SqlConst.RELATION_STAFF_PROJECT_TBL_NAME} VALUES(2, 2, 2);",
        "INSERT INTO ${SqlConst.RELATION_STAFF_PROJECT_TBL_NAME} VALUES(3, 3, 3);",

        "INSERT INTO ${SqlConst.RELATION_PROJECT_COLOR_TBL_NAME} VALUES(1, 1, 1);",
        "INSERT INTO ${SqlConst.RELATION_PROJECT_COLOR_TBL_NAME} VALUES(2, 2, 2);",
        "INSERT INTO ${SqlConst.RELATION_PROJECT_COLOR_TBL_NAME} VALUES(3, 3, 3);"
    )

    /**
     * 各テーブルのCreate(if not exists時)
     */
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sql1)
        db?.execSQL(sql2)
        db?.execSQL(sql3)
        db?.execSQL(sql4)
        db?.execSQL(sql5)
        db?.execSQL(sql6)
        db?.execSQL(sql7)

        for (stub in stubList) {
            db?.execSQL(stub)
        }
    }

    /**
     * DBのバージョンアップ時に呼びされる
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 特に実装しない
    }


//    fun sample() {
//        var dbHelper =
//            SeatChangeSQLiteOpenHelper(
//                context = context,
//                name = SqlConst.DB_NAME,
//                factory = null,
//                version = 1
//            )
//
//        var db = dbHelper.writableDatabase
//
//        val values = ContentValues()
//        values.put("staff_name", "smkw")
//        db.insertOrThrow("staff", null, values)
//
//        val sql = """
//            SELECT * FROM staff;
//        """.trimIndent()
//
//        var cursor = db.rawQuery(sql, null)
//
//        if (cursor.count > 0) {
//            cursor.moveToFirst()
//            while (!cursor.isAfterLast) {
//                var str1 = cursor.getStringOrNull(0)
//                var str2 = cursor.getStringOrNull(1)
//                var str3 = cursor.getStringOrNull(2)
//                cursor.moveToNext()
//            }
//        }
//    }
}