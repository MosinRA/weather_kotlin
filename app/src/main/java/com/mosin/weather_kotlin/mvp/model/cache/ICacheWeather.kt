package com.mosin.weather_kotlin.mvp.model.cache

import com.mosin.weather_kotlin.mvp.model.entity.api.WeatherData
import io.reactivex.rxjava3.core.Single

interface ICacheWeather {
    fun putTo(weatherData: List<WeatherData>)
    fun getFrom(): Single<WeatherData>
}