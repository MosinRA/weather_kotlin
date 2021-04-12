package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wind(
    @Expose
    val speed: Float = 0f,
    @Expose
    val deg: Int = 0
) : Parcelable