package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coord(
    @Expose
    val lat: Float = 0f,
    @Expose
    val lon: Float = 0f
) : Parcelable