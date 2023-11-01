package com.example.myweatherkt.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myweatherkt.R
import com.example.myweatherkt.api.response.BaseResponse
import com.example.myweatherkt.repositories.WeatherRepository

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    val foreCastViewModel:ForeCastViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherRepository = WeatherRepository()
        val mainViewModelFactory = MainViewModelFactory(weatherRepository, application)
        mainViewModel = ViewModelProvider(this,
            mainViewModelFactory)[MainViewModel::class.java]

//        mainViewModel.getCurrentWeatherByCityName("Hà Nội")
//        mainViewModel.currentWeatherResult.observe(this, Observer {response ->
//            when(response){
//                is BaseResponse.Loading -> showLoading()
//
//                is BaseResponse.Success ->{
//                    hideLoading()
//                    val currentWeatherResponse = response.data
//                    Log.d(TAG, "BaseResponse.Success: ${currentWeatherResponse?.name}")
//                }
//
//                is BaseResponse.Error->{
//                    hideLoading()
//                    Log.d(TAG, "BaseResponse.Error: ${response.message}")
//                }
//            }
//        })

        mainViewModel.getCurrentWeatherByLocation("21.047668481091037 ","105.7625009469332")
        mainViewModel.currentWeatherLocationResult.observe(this, Observer {response ->
            when(response){
                is BaseResponse.Loading -> showLoading()

                is BaseResponse.Success ->{
                    hideLoading()
                    val currentWeatherResponse = response.data
                    Log.d(TAG, "BaseResponse.Success: ${currentWeatherResponse?.name}")
                }

                is BaseResponse.Error->{
                    hideLoading()
                    Log.d(TAG, "BaseResponse.Error: ${response.message}")
                }
            }
        })

    }
    private fun showLoading() {

    }
    private fun hideLoading() {

    }
}