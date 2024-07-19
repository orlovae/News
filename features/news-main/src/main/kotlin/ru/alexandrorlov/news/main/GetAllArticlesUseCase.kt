package ru.alexandrorlov.news.main

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.news.data.models.Article
import ru.alexandrorlov.news.data.ArticlesRepository

class GetAllArticlesUseCase(private val repository: ArticlesRepository) {

    operator fun invoke(): Flow<List<Article>> = repository.getAll()
}