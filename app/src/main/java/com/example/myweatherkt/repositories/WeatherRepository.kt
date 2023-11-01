package com.example.myweatherkt.repositories

import com.example.myweatherkt.api.RetrofitClient
import com.example.myweatherkt.utils.Constants

class WeatherRepository {
    suspend fun getCurrentWeatherByCityName(cityName:String) =
        RetrofitClient.getWeatherAPI.getCurrentWeatherByCityName(cityName,Constants.API_KEY)

    suspend fun getCurrentWeatherByLocation(latitude:String, longitude:String) =
        RetrofitClient.getWeatherAPI.getCurrentWeatherByLocation(latitude,longitude,Constants.API_KEY)
}