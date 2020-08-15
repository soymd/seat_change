package com.example.seatchangeapplication.di

import com.example.seatchangeapplication.MainRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun mainRepository() = MainRepository()

}