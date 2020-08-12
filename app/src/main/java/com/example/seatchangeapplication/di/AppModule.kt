package com.example.seatchangeapplication.di


import com.example.seatchangeapplication.projectconfig.ProjectConfigRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideProjectConfigRepositoryImpl(): ProjectConfigRepositoryImpl {
        return ProjectConfigRepositoryImpl()
    }
}

