package com.berkkanb.boyner.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berkkanb.boyner.data.model.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}
