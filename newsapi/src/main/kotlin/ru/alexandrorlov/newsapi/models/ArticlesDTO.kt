package ru.alexandrorlov.newsapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.alexandrorlov.newsapi.utils.DateTimeUTCSSerializer
import java.util.Date

@Serializable
data class Article(
    @SerialName("source")
    val source: SourceDTO,
    @SerialName("author")
    val author: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String,
    @SerialName("publishedAt")
    @Serializable(with = DateTimeUTCSSerializer::class)
    val publishedAt: Date,
    @SerialName("content")
    val content: String,
)
