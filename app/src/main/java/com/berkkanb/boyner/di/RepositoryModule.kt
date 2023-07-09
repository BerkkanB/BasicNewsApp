package com.berkkanb.boyner.di

import com.berkkanb.boyner.data.repository.BookmarkRepositoryImpl
import com.berkkanb.boyner.data.repository.GetNewsListRepositoryImpl
import com.berkkanb.boyner.data.repository.GetNewsSourceListRepositoryImpl
import com.berkkanb.boyner.domain.BookmarkRepository
import com.berkkanb.boyner.domain.GetNewsListRepository
import com.berkkanb.boyner.domain.GetNewsSourceListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideGetNewsSourceListRepository(repositoryImpl: GetNewsSourceListRepositoryImpl): GetNewsSourceListRepository

    @Binds
    fun provideGetNewsListRepository(repositoryImpl: GetNewsListRepositoryImpl): GetNewsListRepository

    @Binds
    fun provideBookmarkRepository(repositoryImpl: BookmarkRepositoryImpl): BookmarkRepository
}