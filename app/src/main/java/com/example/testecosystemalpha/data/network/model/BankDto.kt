package com.example.testecosystemalpha.data.network.model

import com.google.gson.annotations.SerializedName


data class BankDto(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("city") var city: String? = null
)