package com.mosin.weather_kotlin.mvp.presenter

import android.content.SharedPreferences
import com.github.terrakok.cicerone.Router
import com.mosin.weather.mvp.model.api.model.LocationData
import com.mosin.weather_kotlin.APP_ID
import com.mosin.weather_kotlin.LOCATION_ARG_NAME
import com.mosin.weather_kotlin.R
import com.mosin.weather_kotlin.mvp.model.api.IDataSource
import com.mosin.weather_kotlin.mvp.model.entity.api.WeatherData
import com.mosin.weather_kotlin.mvp.navigation.IScreens
import com.mosin.weather_kotlin.mvp.view.WeatherView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class WeatherPresenter() : MvpPresenter<WeatherView>() {

    @Inject
    lateinit var router: Router

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var sp: SharedPreferences

    @Inject
    lateinit var retrofit: IDataSource

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initWeatherData()
    }

    private fun initWeatherData() {
        compositeDisposable.add(
            retrofit.getWeather(sp.getString(LOCATION_ARG_NAME, "Сургут").toString(), APP_ID)
                .observeOn(uiScheduler)
                .subscribe({
                    loadData(it)
                }, {
                    viewState.showErrorRetrofit(it)
                })
        )
    }

        private fun loadData(weatherData: WeatherData) {
            val weatherIco: Int = when (weatherData.weather[0].icon) {
                "01d" -> R.drawable.ic_01d
                "02d" -> R.drawable.ic_02d
                "03d" -> R.drawable.ic_03d
                "04d" -> R.drawable.ic_03d
                "09d" -> R.drawable.ic_09d
                "10d" -> R.drawable.ic_10d
                "11d" -> R.drawable.ic_11d
                "13d" -> R.drawable.ic_13d
                "50d" -> R.drawable.ic_50d
                "01n" -> R.drawable.ic_01d
                "02n" -> R.drawable.ic_02d
                "03n" -> R.drawable.ic_03d
                "04n" -> R.drawable.ic_03d
                "09n" -> R.drawable.ic_09d
                "10n" -> R.drawable.ic_10d
                "11n" -> R.drawable.ic_11d
                "13n" -> R.drawable.ic_13d
                "50n" -> R.drawable.ic_50d
                else -> R.drawable.ic_50d
            }
            viewState.setLocationName(weatherData.name)
            println(weatherData.name)
            viewState.setWeather(
                weatherData.main.temp,
                weatherData.main.humidity,
                weatherData.main.pressure,
                weatherData.main.feels_like,
                weatherIco
            )
        }

        fun actionLocationByQuerySelected(query: String) =
            LocationData(query.trim { it <= ' ' }).also {
                if (!it.isEmpty) {
                    sp.edit().apply {
                        putString(LOCATION_ARG_NAME, query)
                        apply()
                    }
                    initWeatherData()
                }
            }

        fun backClick(): Boolean {
            router.exit()
            return true
        }

        override fun onDestroy() {
            compositeDisposable.dispose()
            super.onDestroy()
        }
    }

