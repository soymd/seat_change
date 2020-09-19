package com.example.seatchangeapplication.constant

/**
 * 定数クラス
 */
class SqlConst {

    companion object {
        // DB名
        const val DB_NAME = "seat_change"
        // テーブル名
        const val SEAT_TBL = "seat"
        const val STAFF_TBL = "staff"
        const val PROJECT_TBL = "project"
        const val COLOR_TBL = "color"
        const val RELATION_SEAT_STAFF_TBL = "relation_seat_staff"
        const val RELATION_STAFF_PROJECT_TBL = "relation_staff_project"
        const val RELATION_PROJECT_COLOR_TBL = "relation_project_color"
        // seatテーブル
        const val SEAT_ID = "seat_id"
        const val DESK = "desk"
        const val POSITION_X = "position_x"
        const val POSITION_Y = "position_y"
        // staffテーブル
        const val STAFF_ID = "staff_id"
        const val STAFF_NAME = "staff_name"
        // projectテーブル
        const val PROJECT_ID = "project_id"
        const val PROJECT_NAME = "project_name"
        // colorテーブル
        const val COLOR_ID = "color_id"
        const val COLOR_NAME = "color_name"
        const val COLOR_VALUE = "color_value"
        // relation_seat_staffテーブル
        const val RELATION_SEAT_STAFF_ID = "relation_seat_staff_id"
        // relation_staff_projectテーブル
        const val RELATION_STAFF_PROJECT_ID = "relation_staff_project_id"
        // relation_project_colorテーブル
        const val RELATION_PROJECT_COLOR_ID = "relation_project_color_id"
    }
}