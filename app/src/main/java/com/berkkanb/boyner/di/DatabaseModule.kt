package com.berkkanb.boyner.di

import android.content.Context
import androidx.room.Room
import com.berkkanb.boyner.data.database.BookmarkDao
import com.berkkanb.boyner.data.database.BookmarkDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideBookmarkDatabase(@ApplicationContext context: Context): BookmarkDatabase {
        return Room.databaseBuilder(context, BookmarkDatabase::class.java, "bookmark_database")
            .build()
    }

    @Provides
    fun provideBookmarkDao(bookmarkDatabase: BookmarkDatabase): BookmarkDao {
        return bookmarkDatabase.bookmarkDao()
    }
}