package com.example.testecosystemalpha.data.network.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("numeric") var numeric: String? = null,
    @SerializedName("alpha2") var alpha2: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("emoji") var emoji: String? = null,
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("latitude") var latitude: Int? = null,
    @SerializedName("longitude") var longitude: Int? = null
)