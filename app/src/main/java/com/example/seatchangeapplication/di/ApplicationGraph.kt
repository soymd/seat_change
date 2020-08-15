package com.example.seatchangeapplication.di

import android.content.Context
import com.example.seatchangeapplication.MainViewModel
import com.example.seatchangeapplication.Test
import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
import dagger.BindsInstance
import dagger.Component
import java.util.*

@Component(modules = [AppModule::class])
interface ApplicationGraph {
    fun test(): Test
    fun mainViewModel(): MainViewModel
    fun colorConfigViewModel(): ColorConfigViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationGraph
    }
}