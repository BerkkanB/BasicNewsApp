package com.berkkanb.boyner.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.berkkanb.boyner.data.model.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmark_table")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Insert
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Query("DELETE FROM bookmark_table WHERE url=:url")
    suspend fun deleteBookmark(url: String)
}
