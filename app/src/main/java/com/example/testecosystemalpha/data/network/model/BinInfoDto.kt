package com.example.testecosystemalpha.data.network.model

import com.google.gson.annotations.SerializedName

data class BinInfoDto(
    @SerializedName("number") var numberInfoDto: NumberInfoDto? = NumberInfoDto(),
    @SerializedName("scheme") var scheme: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("prepaid") var prepaid: Boolean? = null,
    @SerializedName("country") var countryDto: CountryDto? = CountryDto(),
    @SerializedName("bank") var bank: BankDto? = BankDto()
)
