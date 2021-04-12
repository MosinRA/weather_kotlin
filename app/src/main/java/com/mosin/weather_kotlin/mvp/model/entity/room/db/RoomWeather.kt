package com.mosin.weather_kotlin.mvp.model.entity.room.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.mosin.weather_kotlin.mvp.model.entity.room.RoomWeatherData

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomWeatherData::class,
        parentColumns = ["id"],
        childColumns = ["wdId"],
        onDelete = ForeignKey.CASCADE
    )]
)
class RoomWeather {
//    @PrimaryKey
//    val id: Int,
//    val main: String,
//    val description: String,
//    val icon: String
}