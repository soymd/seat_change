package com.example.seatchangeapplication.common

/**
 * キャメルケースの文字列をスネークケースに変換するStringの拡張関数
 */
fun String.toSnakeCase(isFistCaseUpper: Boolean = true): String {
    var text: String = ""
    var isFirst = isFistCaseUpper
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
