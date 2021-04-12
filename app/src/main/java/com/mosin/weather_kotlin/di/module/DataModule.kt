package com.mosin.weather_kotlin.di.module

import com.mosin.weather_kotlin.mvp.model.api.IDataSource
import com.mosin.weather_kotlin.mvp.model.cache.ApiWeatherData
import com.mosin.weather_kotlin.mvp.model.cache.IApiWeather
import com.mosin.weather_kotlin.mvp.model.cache.ICacheWeather
import com.mosin.weather_kotlin.mvp.model.network.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun weatherData(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: ICacheWeather
    ): IApiWeather = ApiWeatherData(api, networkStatus, cache)
}