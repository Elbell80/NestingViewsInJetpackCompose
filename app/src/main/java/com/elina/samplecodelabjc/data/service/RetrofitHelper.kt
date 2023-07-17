package com.elina.samplecodelabjc.data.service

import com.elina.samplecodelabjc.BuildConfig
import com.elina.samplecodelabjc.utils.constants.ApiConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Elina on 24/05/2023.
 */

object RetrofitHelper {
    private val apiService: ApiService? = null
    private val gson = GsonBuilder().setLenient().create()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val retrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(ApiConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //.build()
            .client(getOkHttpClient()).build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor)
        }
        return okHttpClient.build()
    }

    fun getApiService(): ApiService {
        return apiService ?: retrofit.create(ApiService::class.java)
    }
}