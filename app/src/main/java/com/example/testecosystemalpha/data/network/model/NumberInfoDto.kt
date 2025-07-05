package com.example.testecosystemalpha.data.network.model

import com.google.gson.annotations.SerializedName

data class NumberInfoDto(
    @SerializedName("length") var length: Int? = null,
    @SerializedName("luhn") var luhn: Boolean? = null
)