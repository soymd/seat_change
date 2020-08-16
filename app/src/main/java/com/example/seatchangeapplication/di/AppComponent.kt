package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.di.module.ActivityModule
import com.example.seatchangeapplication.di.module.AppModule
import com.example.seatchangeapplication.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()
}

//
//import android.app.Application
//import com.example.seatchangeapplication.MainActivity
//import com.example.seatchangeapplication.MainViewModel
////import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
//import com.example.seatchangeapplication.di.module.*
//import dagger.BindsInstance
//import dagger.Component
//import dagger.android.AndroidInjector
//
//
//@Component(
//    modules = [
////        FragmentModule::class,
////        AppModule::class,
//        MainModule::class,
//        ActivityModule::class,
//        ViewModelModule::class
////        MainModule::class
//    ]
//)
//interface AppComponent : AndroidInjector<MainApplication> {
////    fun mainViewModel(): MainViewModel
////    fun colorConfigViewModel(): ColorConfigViewModel
////    fun inject(target: MainActivity)
//
////    @Component.Factory
////    interface Factory {
////        fun create(@BindsInstance context: Context): AppComponent
////    }
//
//    //jre
////    @Component.Builder
////    interface Builder {
////        @BindsInstance
////        fun application(application: Application): Builder
////
////        fun build(): AppComponent
////    }
//
//    //qiita
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<MainApplication>()
//}
