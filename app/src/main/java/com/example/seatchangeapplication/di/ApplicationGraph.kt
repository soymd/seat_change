package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.MainViewModel
import com.example.seatchangeapplication.Test
import dagger.Component

@Component
interface ApplicationGraph {
    fun test(): Test
    fun mainViewModel(): MainViewModel
}