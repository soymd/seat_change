package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.MainRepository
import com.example.seatchangeapplication.colorconfig.ColorConfigRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun mainRepository() = MainRepository()

    @Provides
    fun colorConfigRepositoryImpl() = ColorConfigRepositoryImpl()
}