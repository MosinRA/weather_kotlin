package com.mosin.weather_kotlin.mvp.model.cache

import com.mosin.weather_kotlin.mvp.model.entity.api.WeatherData
import io.reactivex.rxjava3.core.Single

interface IApiWeather {
    fun getWeatherData(weatherData: WeatherData): Single<WeatherData>
}