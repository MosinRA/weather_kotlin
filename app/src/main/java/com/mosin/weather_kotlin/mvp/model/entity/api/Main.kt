package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(
    @Expose
    val temp: Float = 0f,
    @Expose
    val pressure: Int = 0,
    @Expose
    val humidity: Int = 0,
    @Expose
    val feels_like: Float = 0f
) : Parcelable