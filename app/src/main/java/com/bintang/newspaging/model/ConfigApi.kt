package com.bintang.newspaging.model

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ConfigApi {
    @GET("v1/players")
    suspend fun getPlayers(
            @Query("page") page: Int,
            @Query("per_page") per_page: Int
    ): ResponseAPI

    @GET("message/getMessage")
    suspend fun getMessage(
            @Query("page") page: Int,
            @Query("pageSize") pageSize: Int
    ): ResponseMessage
}