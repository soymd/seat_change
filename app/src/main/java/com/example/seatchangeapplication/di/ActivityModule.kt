import com.example.seatchangeapplication.MainActivity
import com.example.seatchangeapplication.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

//package com.example.seatchangeapplication.di
//
//import androidx.lifecycle.ViewModelProvider
//import com.example.seatchangeapplication.MainActivity
//import dagger.Module
//import dagger.Provides
//import dagger.android.ContributesAndroidInjector
//
//@Module
//abstract class ActivityModule {
//    @ContributesAndroidInjector
//    internal abstract fun contributeMainActivity(): MainActivity
//}


@Module
abstract class ActivityModule {

    //@ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainModule::class]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}