package com.mosin.weather.mvp.model.api.model

import java.util.Observable

class LocationData(var name: String) : Observable() {

    override fun toString(): String {
        return "name = \"$name\""
    }

    val isEmpty: Boolean
        get() = name.isEmpty() || name == "No data" || name == "Нет данных" || name == "null"
}