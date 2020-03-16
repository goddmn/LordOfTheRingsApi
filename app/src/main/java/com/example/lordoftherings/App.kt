package com.example.lordoftherings

import android.app.Application
import android.content.Context
import com.example.lordoftherings.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class App : Application() {

    var service: ApiService? = null
    val base_url = "https://the-one-api.herokuapp.com/v1/"
    val auth_token = "CLh4vGQkHK7ol58XiOSb"

    override fun onCreate() {
        super.onCreate()
        service = initRetrofit()
    }

    private fun initRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val bearerInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request =
                    chain.request().newBuilder().addHeader("Authorization", "Bearer $auth_token")
                        .build()
                return chain.proceed(request)
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(bearerInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    fun getAppInstance(context: Context): App {
        return context.applicationContext as App
    }

    fun getRetrofitService(): ApiService? {
        return service
    }
}