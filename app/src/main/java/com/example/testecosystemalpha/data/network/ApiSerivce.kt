package com.example.testecosystemalpha.data.network

import com.example.testecosystemalpha.data.network.model.BinInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiSerivce {
    @GET("/{bin}")
    suspend fun getInfo(@Path("bin") bin: String): BinInfoDto
}