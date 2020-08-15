package com.example.seatchangeapplication.di

import android.app.Application


class AppAplication: Application() {
    companion object {
        lateinit var component: ApplicationGraph private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationGraph.factory().create(applicationContext)
    }
}