package com.berkkanb.boyner.data.repository

import com.berkkanb.boyner.data.database.BookmarkDao
import com.berkkanb.boyner.data.model.BookmarkEntity
import com.berkkanb.boyner.domain.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
): BookmarkRepository {

    override fun getAllBookmarks(): Flow<List<BookmarkEntity>> {
        return bookmarkDao.getAllBookmarks()
    }

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) {
        bookmarkDao.insertBookmark(bookmarkEntity)
    }

    override suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity) {
        bookmarkDao.deleteBookmark(bookmarkEntity.url)
    }

}