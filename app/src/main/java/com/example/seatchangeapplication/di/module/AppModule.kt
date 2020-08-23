package com.example.seatchangeapplication.di.module

import android.content.Context
import com.example.seatchangeapplication.di.MainApplication
import com.example.seatchangeapplication.manager.SeatChangeSQLiteOpenAdapter
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun provideDbManager(context: Context): SeatChangeSQLiteOpenAdapter {
        return SeatChangeSQLiteOpenAdapter(context)
    }
}

//
//import android.app.Application
//import android.content.Context
//import com.example.seatchangeapplication.MainRepository
//import com.example.seatchangeapplication.MainViewModel
//import com.example.seatchangeapplication.colorconfig.ColorConfigRepositoryImpl
//import com.example.seatchangeapplication.colorconfig.ColorConfigViewModel
//import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
//import com.example.seatchangeapplication.manager.DbManager
//import dagger.Module
//import dagger.Provides
//import javax.inject.Singleton
//
//@Module
//class AppModule {
//
////    @Provides
////    fun providesContext(application: Application): Context {
////        return application
////    }
//
////    @Provides
////    fun mainRepository() = MainRepository()
//
////    @Provides
////    fun colorConfigRepositoryImpl(dbManger: DbManager) = ColorConfigRepositoryImpl(dbManger)
////
////    @Provides
////    fun dbManager(context: Context) = DbManager(context)
////
////    @Provides
////    fun provideColorConfigViewModel(repositoryImpl: ColorConfigRepositoryImpl) =
////        ColorConfigViewModel(repositoryImpl)
//
////    @Singleton
////    @Provides
////    fun bindSeatChangeViewModelProviders(): SeatChangeViewModelProviders =
////        SeatChangeViewModelProviders()
//}