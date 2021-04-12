package com.mosin.weather_kotlin.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mosin.weather_kotlin.mvp.model.entity.room.RoomWeatherData


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomWeatherData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomWeatherData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<RoomWeatherData>)

    @Query("SELECT * FROM RoomWeatherData")
    fun getAll(): List<RoomWeatherData>
}