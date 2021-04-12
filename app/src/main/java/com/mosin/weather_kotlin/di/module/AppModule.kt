package com.mosin.weather_kotlin.di.module

import android.content.Context
import com.mosin.weather_kotlin.App
import com.mosin.weather_kotlin.SP_NAME
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
class AppModule(val app: App) {

    @Named("ui")
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun app(): App = app

    @Provides
    fun sharedPreferences() = app.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
}