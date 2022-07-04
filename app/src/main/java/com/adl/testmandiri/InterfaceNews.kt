package com.adl.testmandiri

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface InterfaceNews {

    @GET("sources?apiKey=3b406bdbd69a4d178f9fbe22be757df2")
    fun getCategorynews(): Observable<ResponseNews>

    companion object {

        fun create(): InterfaceNews {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://newsapi.org/v2/top-headlines/")
                .build()
            return retrofit.create(InterfaceNews::class.java)
        }
    }
}
