package com.mosin.weather_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData(
    @Expose
    val timezone: Int = 0,
    @Expose
    val id: Int = 0,
    @Expose
    val name: String = "",
    @Expose
    val cod: Int = 0,
    @Expose
    val coord: Coord = Coord(),
    @Expose
    val weather: Array<Weather> = arrayOf(Weather()),
    @Expose
    val main: Main = Main(),
    @Expose
    val wind: Wind = Wind(),
    @Expose
    val clouds: Clouds = Clouds(),
    @Expose
    val sys: Sys = Sys()
) : Parcelable {
    override fun hashCode(): Int {
        var result = timezone
        result = 31 * result + id
        result = 31 * result + name.hashCode()
        result = 31 * result + cod
        result = 31 * result + coord.hashCode()
        result = 31 * result + weather.contentHashCode()
        result = 31 * result + main.hashCode()
        result = 31 * result + wind.hashCode()
        result = 31 * result + clouds.hashCode()
        result = 31 * result + sys.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WeatherData

        if (timezone != other.timezone) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (cod != other.cod) return false
        if (coord != other.coord) return false
        if (!weather.contentEquals(other.weather)) return false
        if (main != other.main) return false
        if (wind != other.wind) return false
        if (clouds != other.clouds) return false
        if (sys != other.sys) return false

        return true
    }
}