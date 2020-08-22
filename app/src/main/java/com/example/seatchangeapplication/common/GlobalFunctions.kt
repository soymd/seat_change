package com.example.seatchangeapplication.common

import java.lang.Exception

/**
 * キャメルケースの文字列をスネークケースに変換するStringの拡張関数
 */
fun String.toSnakeCase(isFistCaseLower: Boolean = true): String {
    var text: String = ""
    var isFirst = true
    if (isFistCaseLower) {
        isFirst = false
    }
    this.forEach {
        if (it.isUpperCase()) {
            if (isFirst){
                isFirst = false
            } else {
                text += "_"
                text += it.toLowerCase()
            }
        } else {
            text += it
        }
    }
    return text
}
