package com.mosin.weather_kotlin.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import com.mosin.weather_kotlin.App
import com.mosin.weather_kotlin.IBackClickListener
import com.mosin.weather_kotlin.R
import com.mosin.weather_kotlin.databinding.FragmentWeatherBinding
import com.mosin.weather_kotlin.mvp.presenter.WeatherPresenter
import com.mosin.weather_kotlin.mvp.view.WeatherView
import com.mosin.weather_kotlin.showToast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*

class WeatherFragment : MvpAppCompatFragment(), WeatherView, IBackClickListener,
    SearchView.OnQueryTextListener {

    private lateinit var searchItem: MenuItem

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private val presenter by moxyPresenter {
        WeatherPresenter(
        ).apply {
            App.instance.appComponent.inject(this)
            setHasOptionsMenu(true)
        }
    }

    private var ui: FragmentWeatherBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWeatherBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search, menu)
        searchItem = menu.findItem(R.id.action_search)
        (searchItem.actionView as SearchView).setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searchItem.collapseActionView()
        if (query.trim { it <= ' ' }.isEmpty()) return false
        presenter.actionLocationByQuerySelected(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        return false
    }

    override fun setLocationName(cityName: String) {
        ui?.cityNameBig?.text = cityName.toUpperCase(Locale.ROOT)
    }

    override fun setWeather(temp: Float, humidity: Int, pressure: Int, tempLike: Float, ico:Int) {
        ui?.tempTextView?.text = temp.toString()
        ui?.humidityVal?.text = humidity.toString()
        ui?.pressureVal?.text = pressure.toString()
        ui?.tempLikeVal?.text = tempLike.toString()
        ui?.weatherIcoView?.setImageResource(ico)
    }

    override fun showErrorLocation(error: Throwable) {
        context?.showToast("Ошибка определения текущего положения: $error")
    }

    override fun showErrorRetrofit(error: Throwable) {
        context?.showToast("Ошибка запроса возможно неверно указан город")
    }

    override fun showErrorDB(error: Throwable) {
        context?.showToast("Ошибка операции БД: $error")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun backPressed() = presenter.backClick()
}