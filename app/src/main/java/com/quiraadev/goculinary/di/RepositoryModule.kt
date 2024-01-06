package com.quiraadev.goculinary.di

import com.quiraadev.goculinary.data.local.CulinaryDao
import com.quiraadev.goculinary.data.repository.CulinaryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(dao : CulinaryDao) = CulinaryRepository(dao)
}