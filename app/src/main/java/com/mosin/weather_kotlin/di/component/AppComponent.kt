package com.mosin.weather_kotlin.di.component

import com.mosin.weather_kotlin.di.module.*
import com.mosin.weather_kotlin.mvp.presenter.MainPresenter
import com.mosin.weather_kotlin.mvp.presenter.WeatherPresenter
import com.mosin.weather_kotlin.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        NavigationModule::class,
        DataModule::class,
        CacheModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(weatherPresenter: WeatherPresenter)
}