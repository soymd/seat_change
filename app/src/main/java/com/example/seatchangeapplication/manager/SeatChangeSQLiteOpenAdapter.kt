package com.example.seatchangeapplication.manager

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.seatchangeapplication.colorconfig.ColorConfigModel
import com.example.seatchangeapplication.common.toSnakeCase
import com.example.seatchangeapplication.constant.ErrorConst
import com.example.seatchangeapplication.constant.SqlConst.Companion.COLOR_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.COLOR_NAME
import com.example.seatchangeapplication.constant.SqlConst.Companion.COLOR_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.COLOR_VALUE
import com.example.seatchangeapplication.constant.SqlConst.Companion.DB_NAME
import com.example.seatchangeapplication.constant.SqlConst.Companion.DESK
import com.example.seatchangeapplication.constant.SqlConst.Companion.POSITION_X
import com.example.seatchangeapplication.constant.SqlConst.Companion.POSITION_Y
import com.example.seatchangeapplication.constant.SqlConst.Companion.PROJECT_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.PROJECT_NAME
import com.example.seatchangeapplication.constant.SqlConst.Companion.PROJECT_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_PROJECT_COLOR_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_PROJECT_COLOR_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_SEAT_STAFF_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_SEAT_STAFF_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_STAFF_PROJECT_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.RELATION_STAFF_PROJECT_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.SEAT_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.SEAT_TBL
import com.example.seatchangeapplication.constant.SqlConst.Companion.STAFF_ID
import com.example.seatchangeapplication.constant.SqlConst.Companion.STAFF_NAME
import com.example.seatchangeapplication.constant.SqlConst.Companion.STAFF_TBL
import com.example.seatchangeapplication.dto.RelationProjectColor
import com.example.seatchangeapplication.dto.RelationSeatStaff
import com.example.seatchangeapplication.dto.RelationStaffProject
import com.example.seatchangeapplication.projectconfig.ProjectConfigModel
import com.example.seatchangeapplication.seatchange.SeatChangeModel
import javax.inject.Inject
import kotlin.reflect.full.memberProperties
import kotlin.Int as Int

/**
 * DB操作機能を保持するクラス
 */
class SeatChangeSQLiteOpenAdapter @Inject constructor(context: Context) {

    private var mDb: SQLiteDatabase?
    private val TAG = this::class.simpleName.toString()

    init {
        var dbHelper =
            SeatChangeSQLiteOpenHelper(
                context,
                DB_NAME,
                null,
                1
            )
        mDb = dbHelper.writableDatabase
    }

    /**
     * 検索結果カーソルからモデルのリストを取得する
     */
    private fun <IModel> getFromRawQuery(sql: String, action:(Cursor) -> IModel): List<IModel> {
        var modelList = arrayListOf<IModel>()
        var cursor: Cursor? = null;
        try {
            cursor = mDb?.rawQuery(sql, arrayOf()) ?: throw Exception()
            while (cursor.moveToNext()) {
                modelList.add(action(cursor))
            }
        } catch (e: Exception) {
            // TODO: DBロック時などエラーハンドリングとトランザクションの制御
            throw DbOperationException(e.message.toString())
        } finally {
            cursor?.close()
        }
        return modelList;
    }

    /**
     * 席替画面：get
     */
    fun getSeatStaffProjectColor(): List<SeatChangeModel> {
        /* NOTE:
         * SqLiteはASで別名付けないとExceptionを吐く(SqLiteのバグ)。
         * 値は取れるがtry-catchに引っかかるため、別名は必須。
         */
        var sql = """
            SELECT
                $RELATION_SEAT_STAFF_TBL.$RELATION_SEAT_STAFF_ID AS "alt_relation_id", 
                $SEAT_TBL.$DESK AS "alt_desk",
                $SEAT_TBL.$POSITION_X AS "alt_position_x",
                $SEAT_TBL.$POSITION_Y AS "alt_position_y",
                $STAFF_TBL.$STAFF_NAME AS "alt_staff_name",
                $PROJECT_TBL.$PROJECT_NAME AS "alt_project_name",
                $COLOR_TBL.$COLOR_VALUE AS "alt_color_value"
            FROM $SEAT_TBL
            INNER JOIN $RELATION_SEAT_STAFF_TBL
            ON $SEAT_TBL.$SEAT_ID = $RELATION_SEAT_STAFF_TBL.$SEAT_ID
            INNER JOIN $STAFF_TBL
            ON $STAFF_TBL.$STAFF_ID = $RELATION_SEAT_STAFF_TBL.$STAFF_ID
            INNER JOIN $RELATION_STAFF_PROJECT_TBL
            ON $STAFF_TBL.$STAFF_ID = $RELATION_STAFF_PROJECT_TBL.$STAFF_ID
            INNER JOIN $PROJECT_TBL
            ON $PROJECT_TBL.$PROJECT_ID = $RELATION_STAFF_PROJECT_TBL.$PROJECT_ID
            INNER JOIN $RELATION_PROJECT_COLOR_TBL
            ON $PROJECT_TBL.$PROJECT_ID = $RELATION_PROJECT_COLOR_TBL.$PROJECT_ID
            INNER JOIN $COLOR_TBL
            ON $COLOR_TBL.$COLOR_ID = $RELATION_PROJECT_COLOR_TBL.$COLOR_ID
        """.trimIndent()

        return getFromRawQuery(sql) { cursor ->
            SeatChangeModel.from().apply {
                this.relationSeatStaffId = cursor.getAny("alt_relation_id")
                this.desk = cursor.getAny("alt_desk")
                this.positionX = cursor.getAny("alt_position_x")
                this.positionY = cursor.getAny("alt_position_y")
                this.staffName = cursor.getAny("alt_staff_name")
                this.projectName = cursor.getAny("alt_project_name")
                this.projectColorValue = cursor.getAny("alt_color_value")
            }
        }
    }

    /**
     * 案件設定画面：get
     */
    fun getStaffProjectColor(): List<ProjectConfigModel> {
        var sql = """
            SELECT 
                $RELATION_STAFF_PROJECT_TBL.$RELATION_STAFF_PROJECT_ID AS "alt_relation_id",
                $STAFF_TBL.$STAFF_NAME AS "alt_staff_name",
                $PROJECT_TBL.$PROJECT_NAME AS "alt_project_name",
                $COLOR_TBL.$COLOR_VALUE AS "alt_color_value"
            FROM $STAFF_TBL
            INNER JOIN $RELATION_STAFF_PROJECT_TBL
            ON $STAFF_TBL.$STAFF_ID = $RELATION_STAFF_PROJECT_TBL.$STAFF_ID
            INNER JOIN $PROJECT_TBL
            ON $PROJECT_TBL.$PROJECT_ID = $RELATION_STAFF_PROJECT_TBL.$PROJECT_ID
            INNER JOIN $RELATION_PROJECT_COLOR_TBL
            ON $PROJECT_TBL.$PROJECT_ID = $RELATION_PROJECT_COLOR_TBL.$PROJECT_ID
            INNER JOIN $COLOR_TBL
            ON $COLOR_TBL.$COLOR_ID = $RELATION_PROJECT_COLOR_TBL.$COLOR_ID
        """.trimIndent()

        return getFromRawQuery(sql) { cursor ->
            ProjectConfigModel.from().apply {
                this.relationStaffProjectId = cursor.getAny("alt_relation_id")
                this.staffName = cursor.getAny("alt_staff_name")
                this.projectName = cursor.getAny("alt_project_name")
                this.projectColorValue = cursor.getAny("alt_color_value")
            }
        }
    }

    /**
     * 色設定画面：get
     */
    fun getProjectColor(): List<ColorConfigModel> {
        var sql = """
            SELECT
                $RELATION_PROJECT_COLOR_TBL.$RELATION_PROJECT_COLOR_ID AS "alt_relation_name",
                $PROJECT_TBL.$PROJECT_NAME AS "alt_project_name",
                $COLOR_TBL.$COLOR_NAME AS "alt_color_name",
                $COLOR_TBL.$COLOR_VALUE AS "alt_color_value"
            FROM $PROJECT_TBL
            INNER JOIN $RELATION_PROJECT_COLOR_TBL
            ON $PROJECT_TBL.$PROJECT_ID = $RELATION_PROJECT_COLOR_TBL.$PROJECT_ID
            INNER JOIN $COLOR_TBL
            ON $COLOR_TBL.$COLOR_ID = $RELATION_PROJECT_COLOR_TBL.$COLOR_ID
        """.trimIndent()
        
        return getFromRawQuery(sql) { cursor ->
            ColorConfigModel.from().apply {
                this.relationProjectColorId = cursor.getAny("alt_relation_name")
                this.projectName = cursor.getAny("alt_project_name")
                this.colorName = cursor.getAny("alt_color_name")
                this.colorValue = cursor.getAny("alt_color_value")
            }
        }
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
    fun postProjectColorModels(model: ColorConfigModel): Int {
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

    /**
     * ContentValuesに任意のDTOのkey/valueを格納する
     */
    private inline fun <reified T : Any> getContentValue(dto: T): ContentValues? {
        var contentValues = ContentValues()
        try {
            T::class.memberProperties.forEach { param ->
                contentValues.castAndPut(param.name.toSnakeCase(false), param.get(dto))
            }
        } catch (e: DbOperationException) {
            return null
        }
        return contentValues
    }

    /**
     * ContentValues#put に Any? を押し込めるようにした拡張関数。
     * nullの時はDbOperationExceptionをthrowする。
     */
    private fun ContentValues.castAndPut(key: String, v: Any?) {
        when (v) {
            is Double -> this.put(key, v)
            is Int -> this.put(key, v)
            is Boolean -> this.put(key, v)
            is String -> this.put(key, v)
            else -> throw DbOperationException(ErrorConst.INVALID_DTO_TYPE)
        }
    }

    /**
     * 検索結果のCursorから任意の型の情報を取得する拡張関数。
     */
    private inline fun <reified T> Cursor.getAny(key: String): T {
        try {
            return when (T::class) {
                Double::class -> this.getDouble(this.getColumnIndex(key)) as T
                Int::class -> this.getInt(this.getColumnIndex(key)) as T
                String::class -> this.getString(this.getColumnIndex(key)) as T
                else -> throw Exception()
            }
        } catch (e: Exception) {
            // TODO: エラーハンドリング
            Log.d(TAG, e.message.toString())
            this.close()
            throw DbOperationException(e.message.toString())
        }
        return 0 as T
    }
}

class DbOperationException(message: String) : Exception(message)

