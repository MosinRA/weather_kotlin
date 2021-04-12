package com.mosin.weather_kotlin.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mosin.weather_kotlin.mvp.model.entity.room.RoomWeatherData
import com.mosin.weather_kotlin.mvp.model.entity.room.dao.WeatherDao


@androidx.room.Database(
    entities = [
        RoomWeatherData::class
    ],
    version = 1
)

abstract class Database : RoomDatabase() {
    abstract val weatherDao: WeatherDao

    companion object {
        const val DB_NAME = "dbWea.db"
        private var instance: Database? = null
        fun getInstance() = instance ?: throw IllegalAccessException("База данных не создана")
        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, Database::class.java, DB_NAME)
                    .build()
            }
        }

    }
}