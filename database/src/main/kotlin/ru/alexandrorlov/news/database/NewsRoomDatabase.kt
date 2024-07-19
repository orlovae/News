package ru.alexandrorlov.news.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexandrorlov.news.database.dao.ArticlesDao
import ru.alexandrorlov.news.database.models.ArticlesDBO
import ru.alexandrorlov.news.database.utils.Converters

class NewsDatabase internal constructor(private val database: NewsRoomDatabase) {

    val articlesDao: ArticlesDao
        get() = database.articlesDao()
}

@Database(entities = [ArticlesDBO::class], version = 1)
@TypeConverters(Converters::class)
internal abstract class NewsRoomDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

}

fun NewsDatabase(applicationContext: Context): NewsDatabase {
    val newsRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        NewsRoomDatabase::class.java,
        "news"
    ).build()
    return NewsDatabase(newsRoomDatabase)
}