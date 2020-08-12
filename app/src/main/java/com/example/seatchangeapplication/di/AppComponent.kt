package com.example.seatchangeapplication.di

import ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()
}

//import android.app.Application
//import dagger.BindsInstance
//import dagger.Component
//import dagger.android.AndroidInjector
//import dagger.android.support.AndroidSupportInjectionModule
//import javax.inject.Singleton
//
//@Singleton
//@Component(modules = [
//    AppModule::class,
//    ActivityModule::class
//])
//interface AppComponent : AndroidInjector<App> {
//
//    // AndroidInjector.Builderをそのまま使ってる
//    //   @BindsInstanceによってAppクラスを依存解決できるようになってる
//    //   createメソッドが定義されている
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<App>()
//}