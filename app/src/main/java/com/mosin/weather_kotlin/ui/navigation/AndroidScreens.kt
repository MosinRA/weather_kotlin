package com.mosin.weather_kotlin.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mosin.weather_kotlin.mvp.navigation.IScreens
import com.mosin.weather_kotlin.ui.fragment.WeatherFragment

class AndroidScreens: IScreens {
    override fun weather() = FragmentScreen { WeatherFragment.newInstance() }
    }
