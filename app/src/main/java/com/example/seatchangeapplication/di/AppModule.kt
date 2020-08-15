package com.example.seatchangeapplication.di

import android.content.Context
import com.example.seatchangeapplication.MainRepository
import com.example.seatchangeapplication.colorconfig.ColorConfigRepositoryImpl
import com.example.seatchangeapplication.manager.DbManager
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun mainRepository() = MainRepository()

    @Provides
    fun colorConfigRepositoryImpl(dbManger: DbManager) = ColorConfigRepositoryImpl(dbManger)

    @Provides
    fun dbManager(context: Context) = DbManager(context)
}