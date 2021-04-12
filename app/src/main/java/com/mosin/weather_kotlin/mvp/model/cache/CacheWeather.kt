package com.mosin.weather_kotlin.mvp.model.cache

import com.mosin.weather_kotlin.mvp.model.entity.api.*
import com.mosin.weather_kotlin.mvp.model.entity.room.RoomWeatherData
import com.mosin.weather_kotlin.mvp.model.entity.room.db.Database
import io.reactivex.rxjava3.core.Single

class CacheWeather(private val db: Database) : ICacheWeather {

    override fun putTo(weatherData: List<WeatherData>) {
        val roomWeather = weatherData.map { wd ->
            RoomWeatherData(
                wd.name,
                wd.timezone,
                wd.id,
                wd.cod,
                wd.coord,
                wd.main,
                wd.wind,
                wd.clouds,
                wd.sys
            )
        }
        db.weatherDao.insert(roomWeather)
    }

    override fun getFrom(): Single<WeatherData> {
        TODO("Not yet implemented")
    }


//    override fun getFrom() = Single.fromCallable {
//        db.weatherDao.getAll().map { wd ->
//            WeatherData(
//                wd.timezone,
//                wd.id,
//                wd.name,
//                wd.cod,
//                wd.coord,
//                wd.weather,
//                wd.main,
//                wd.wind,
//                wd.clouds,
//                wd.sys
//            )
//        }
//    }
}