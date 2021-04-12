package com.mosin.weather_kotlin.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.mosin.weather_kotlin.mvp.navigation.IScreens
import com.mosin.weather_kotlin.ui.navigation.AndroidScreens
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    fun router(): Router = cicerone.router

    @Provides
    fun screens(): IScreens = AndroidScreens()
}