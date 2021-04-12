package com.mosin.weather_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface WeatherView : MvpView {
    fun setLocationName(value: String)

    fun setWeather(temp: Float, humidity: Int, pressure: Int, tempLike: Float, iconNumber:Int)

    fun showErrorLocation(error: Throwable)
    fun showErrorRetrofit(error: Throwable)
    fun showErrorDB(error: Throwable)
}