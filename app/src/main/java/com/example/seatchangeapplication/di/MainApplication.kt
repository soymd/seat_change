package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


class MainApplication : DaggerApplication() {
    companion object {
        const val DEBUG_TAG = "debug_tag"
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
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