package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.MainViewModel
import com.example.seatchangeapplication.Test
import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface ApplicationGraph {
    fun test(): Test
    fun mainViewModel(): MainViewModel
    fun colorConfigViewModel(): ColorConfigViewModel
}