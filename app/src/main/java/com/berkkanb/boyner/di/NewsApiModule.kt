package com.berkkanb.boyner.di

import com.berkkanb.boyner.data.repository.GetNewsSourceListRepositoryImpl
import com.berkkanb.boyner.domain.GetNewsSourceListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NewsApiModule {
    @Binds
    fun provideGetNewsSourceListRepository(repositoryImpl: GetNewsSourceListRepositoryImpl):GetNewsSourceListRepository
}