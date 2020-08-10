package com.example.seatchangeapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.database.getStringOrNull


class SeatChangeSQLiteOpenHelper(
    val context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(
    context,
    name,
    factory,
    version)
{

    override fun onCreate(db: SQLiteDatabase?) {
        val sql1 = """
            CREATE TABLE if not exists "seat" (
            	"seat_id"	INTEGER NOT NULL,
            	"desk"	INTEGER NOT NULL,
            	"position_x"	INTEGER NOT NULL,
            	"position_y"	INTEGER NOT NULL,
            	PRIMARY KEY("seat_id" AUTOINCREMENT)
            )
        """.trimIndent()

        val sql2 = """
            CREATE TABLE if not exists "staff" (
            	"staff_id"	INTEGER NOT NULL,
            	"staff_name"	INTEGER NOT NULL,
            	PRIMARY KEY("staff_id")
            )
        """.trimIndent()

        val sql3 = """
            CREATE TABLE if not exists "project" (
                "project_id"	INTEGER NOT NULL,
                "project_name"	TEXT NOT NULL,
                PRIMARY KEY("project_id" AUTOINCREMENT)
            )
        """.trimIndent()

        val sql4 = """
            CREATE TABLE if not exists "color" (
            	"color_id"	INTEGER NOT NULL,
            	"color_name"	TEXT NOT NULL,
            	"color_value"	TEXT NOT NULL,
            	PRIMARY KEY("color_id" AUTOINCREMENT)
            )
        """.trimIndent()



        val sql5 = """
            CREATE TABLE if not exists "relation_seat_staff" (
            	"relation_seat_staff_id"	INTEGER NOT NULL,
            	"seat_id"	INTEGER NOT NULL,
            	"staff_id"	INTEGER NOT NULL,
            	PRIMARY KEY("relation_seat_staff_id" AUTOINCREMENT)
            )
        """.trimIndent()

        val sql6 = """
            CREATE TABLE if not exists "relation_staff_project" (
            	"relation_staff_project_id"	INTEGER NOT NULL,
            	"staff_id"	INTEGER NOT NULL,
            	"project_id"	INTEGER NOT NULL,
            	PRIMARY KEY("relation_staff_project_id" AUTOINCREMENT)
            )
        """.trimIndent()


        val sql7 = """
            CREATE TABLE if not exists "relation_project_color" (
            	"relation_project_color_id"	INTEGER NOT NULL,
            	"project_id"	INTEGER NOT NULL,
            	"color_id"	INTEGER NOT NULL,
            	PRIMARY KEY("relation_project_color_id" AUTOINCREMENT)
            )
        """.trimIndent()

        db?.execSQL(sql1)
        db?.execSQL(sql2)
        db?.execSQL(sql3)
        db?.execSQL(sql4)
        db?.execSQL(sql5)
        db?.execSQL(sql6)
        db?.execSQL(sql7)
    }


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