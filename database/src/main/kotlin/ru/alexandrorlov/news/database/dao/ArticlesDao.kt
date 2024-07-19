package ru.alexandrorlov.news.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.news.database.models.ArticlesDBO

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM articles")
    fun getAll(): Flow<List<ArticlesDBO>>

    @Insert
    suspend fun insert(articles: List<ArticlesDBO>)

    @Delete
    suspend fun remove(articles: List<ArticlesDBO>)

    @Query("DELETE FROM articles")
    suspend fun clean()
}