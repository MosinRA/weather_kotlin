package com.mosin.weather_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.weather_kotlin.mvp.navigation.IScreens
import com.mosin.weather_kotlin.mvp.view.WeatherView
import moxy.MvpPresenter
import javax.inject.Inject


class MainPresenter() : MvpPresenter<WeatherView>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.weather())
    }

    fun backPressed() {
        router.exit()
    }
}
