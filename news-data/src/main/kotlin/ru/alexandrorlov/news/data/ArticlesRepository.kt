package ru.alexandrorlov.news.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alexandrorlov.newsapi.NewsApi
import ru.alexandrorlov.news.data.models.Article
import ru.alexandrorlov.news.database.NewsDatabase


class ArticlesRepository(
    private val database: NewsDatabase,
    private val api: NewsApi,
) {
    fun getAll(): Flow<List<Article>> =
        database.articlesDao
            .getAll()
            .map { articlesDBO ->
                articlesDBO.map {
                    it.toArticle()
                }
            }

    suspend fun search(): Flow<Article> {
        api.everything()
    }
}