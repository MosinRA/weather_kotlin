package com.mosin.weather_kotlin.di.module

import androidx.room.Room
import com.mosin.weather_kotlin.App
import com.mosin.weather_kotlin.mvp.model.cache.CacheWeather
import com.mosin.weather_kotlin.mvp.model.cache.ICacheWeather
import com.mosin.weather_kotlin.mvp.model.entity.room.db.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Provides
    @Singleton
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

    @Provides
    @Singleton
    fun usersCache(db: Database): ICacheWeather = CacheWeather(db)
}