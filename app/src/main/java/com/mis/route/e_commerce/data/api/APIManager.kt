package com.mis.route.e_commerce.data.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIManager {
    const val LOGGING_TAG = "APIService"

    private var retrofit: Retrofit? = null

    private fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl("https://ecommerce.routemisr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getAPIServices(): WebServices {
        return getInstance().create(WebServices::class.java)
    }

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor { message ->
            Log.d(LOGGING_TAG, message)
        }
        // BODY – Logs request and response lines and their respective headers and bodies
        // (if present). This is the only log level where we will get the response body data.
        // NONE – No logs. Use this for production releases to enhance the apps performance.
        // TODO: set the level to NONE before releasing the app
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}