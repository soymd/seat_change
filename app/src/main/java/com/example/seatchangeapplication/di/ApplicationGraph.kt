package com.example.seatchangeapplication.di

import android.content.Context
import com.example.seatchangeapplication.MainViewModel
import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface ApplicationGraph {
    fun mainViewModel(): MainViewModel
    fun colorConfigViewModel(): ColorConfigViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationGraph
    }
}