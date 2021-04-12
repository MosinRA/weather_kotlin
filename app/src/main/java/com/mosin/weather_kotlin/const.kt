package com.mosin.weather_kotlin

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast

const val BASE_URL = "https://api.openweathermap.org/"
const val APP_ID = "f6aa08967f40de3bede2207faf10d0a6"
const val SP_NAME = "weathermosin.prefs"

const val LOCATION_ARG_NAME = "location_name"

fun Context.showToast(msg: String) {
    if (Looper.getMainLooper() == Looper.myLooper()) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    } else {
        Handler(Looper.getMainLooper()).post { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show() }
    }
    Log.d(TAG, msg)
}