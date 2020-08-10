package com.example.seatchangeapplication.seatchange

data class SeatChangeModel(
    var relationSeatStaffId: Int,
    var staffName: String,
    var projectName: String,
    var desk: Int,
    var positionX: Int,
    var positionY: Int,
    var projectColorValue: String
) {
    companion object {
        fun getInstance(): SeatChangeModel {
            return SeatChangeModel(
                relationSeatStaffId = 0,
                staffName = "",
                projectName = "",
                desk = 0,
                positionX = 0,
                positionY = 0,
                projectColorValue = "#ffffff"
            )
        }
    }
}
