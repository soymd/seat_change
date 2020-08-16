package com.example.seatchangeapplication.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}

//class MainApplication : DaggerApplication() {
////    companion object {
////        lateinit var component: AppComponent private set
////    }
//
////    override fun onCreate() {
////        super.onCreate()
////        component = DaggerApplicationGraph.factory().create(applicationContext)
////    }
//
//
//    override fun applicationInjector() = component
//
//    val component: AppComponent = DaggerAppComponent.builder()
//        .application(this)
//        .build()
//
//}