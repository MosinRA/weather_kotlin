package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sys(
    @Expose
    val country: String = "",
    @Expose
    val sunrise: Long = 0,
    @Expose
    val sunset: Long = 0
) : Parcelable