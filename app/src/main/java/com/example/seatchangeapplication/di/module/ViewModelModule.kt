package com.example.seatchangeapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.seatchangeapplication.MainViewModel
import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
import com.example.seatchangeapplication.di.ViewModelFactory
import com.example.seatchangeapplication.di.ViewModelKey
import com.example.seatchangeapplication.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ColorConfigViewModel::class)
    abstract fun bindColorConfigViewModel(viewModel: ColorConfigViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel
}

//
//import androidx.lifecycle.ViewModelProvider
//import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
//import com.example.seatchangeapplication.di.ViewModelFactory
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import javax.inject.Singleton
//
//@Module
//abstract class ViewModelModule {
//
//    @Binds
//    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):
//            ViewModelProvider.Factory
//
////    @Singleton
////    @Provides
////    fun bindSeatChangeViewModelProviders(): SeatChangeViewModelProviders =
////        SeatChangeViewModelProviders()
//}