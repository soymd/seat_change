package com.example.seatchangeapplication.di.module

import com.example.seatchangeapplication.MainActivity
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import com.example.seatchangeapplication.di.ActivityScoped
import com.example.seatchangeapplication.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeColorConfigFragment(): ColorConfigFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeMenuFragment(): MenuFragment
}

//@Module
//internal abstract class ActivityModule {
//
//    //    @ActivityScope
//    @ContributesAndroidInjector(
//        modules = [MainModule::class]
//    )
//    internal abstract fun contributeMainActivity(): MainActivity
//}

//@Scope
//@Retention(AnnotationRetention.RUNTIME)
//internal annotation class ActivityScope