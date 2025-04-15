package com.example.catfightingclub.di

import com.example.catfightingclub.model.CatsService
import com.example.catfightingclub.model.CatsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatsServiceModule {
    @Provides
    @Singleton
    fun provideCatsService(): CatsService {
        return CatsServiceImpl()
    }
}
