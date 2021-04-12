package com.mosin.weather_kotlin.mvp.model.api

import com.mosin.weather_kotlin.mvp.model.entity.api.WeatherData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {

    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") location: String,
        @Query("appid") appId: String?,
        @Query("lang") lang: String = "RU",
        @Query("units") units: String = "metric"
    ): Single<WeatherData>
}