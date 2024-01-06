package com.quiraadev.goculinary.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.quiraadev.goculinary.data.local.CulinaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(application: Application) = Room
        .databaseBuilder(application, CulinaryDatabase::class.java, "culinary.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideDao(database: CulinaryDatabase) = database.dao()
}