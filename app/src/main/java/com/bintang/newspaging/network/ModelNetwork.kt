package com.bintang.newspaging.network

import com.bintang.newspaging.constant.ConstantApi
import com.bintang.newspaging.model.ConfigApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore

class ModelNetwork {

    companion object {

        fun getClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
           val client = OkHttpClient.Builder()
                   .addInterceptor(logging)
                   .build()
            return client
        }
        fun getRetrofit(): Retrofit {
            val constant: ConstantApi
            constant = ConstantApi()
            val retrofit = Retrofit.Builder()
                    .baseUrl(constant.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build()
            return retrofit
        }
        fun initService(): ConfigApi {
            return getRetrofit().create(ConfigApi::class.java)
        }
    }
}