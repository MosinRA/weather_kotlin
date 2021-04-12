package com.mosin.weather_kotlin.mvp.model.cache

import com.mosin.weather_kotlin.APP_ID
import com.mosin.weather_kotlin.mvp.model.api.IDataSource
import com.mosin.weather_kotlin.mvp.model.entity.api.WeatherData
import com.mosin.weather_kotlin.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiWeatherData(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: ICacheWeather,
) : IApiWeather {
    override fun getWeatherData(weatherData: WeatherData) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline)
                api.getWeather(weatherData.name, APP_ID).doAfterSuccess { weather ->
                    cache.putTo(listOf(weather))
                }
            else cache.getFrom()
        }.subscribeOn(Schedulers.io())
}