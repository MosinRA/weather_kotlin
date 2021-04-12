package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    @Expose
    val id: Int = 0,
    @Expose
    val main: String = "",
    @Expose
    val description: String = "",
    @Expose
    val icon: String = ""
) : Parcelable