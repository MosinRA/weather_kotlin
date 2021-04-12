package com.mosin.weather_kotlin

import android.app.Application
import com.mosin.weather_kotlin.di.component.AppComponent
import com.mosin.weather_kotlin.di.component.DaggerAppComponent
import com.mosin.weather_kotlin.di.module.AppModule
import com.mosin.weather_kotlin.mvp.model.entity.room.db.Database

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}