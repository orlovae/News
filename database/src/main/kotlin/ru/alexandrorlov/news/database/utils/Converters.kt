package ru.alexandrorlov.news.database.utils

import androidx.room.TypeConverter
import java.text.DateFormat
import java.util.Date

internal class Converters {

    @TypeConverter
    fun fromTimestamp(value: String?): Date? =
        value?.let { DateFormat.getDateInstance().parse(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): String? =
        date?.time?.let { DateFormat.getDateInstance().format(it) }
}