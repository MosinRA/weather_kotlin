package com.mosin.weather_kotlin.mvp.model.entity.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mosin.weather_kotlin.mvp.model.entity.api.*

@Entity
class RoomWeatherData(
    @PrimaryKey val name: String,
    val timezone: Int,
    val id: Int,
    val cod: Int,
    @Embedded val coord: Coord,
//    @Embedded val weather: Array<Weather>,
    @Embedded val main: Main,
    @Embedded val wind: Wind,
    @Embedded val clouds: Clouds,
    @Embedded val sys: Sys
)