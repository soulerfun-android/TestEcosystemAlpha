package com.example.testecosystemalpha.data.mapper

import com.example.testecosystemalpha.data.database.BinItemDbModel
import com.example.testecosystemalpha.data.network.model.BinInfoDto
import com.example.testecosystemalpha.domain.entity.BinInfoItem
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapDtoItemToEntity(binInfoDto: BinInfoDto): BinInfoItem {
        return BinInfoItem(
            binNumber = "",
            country = binInfoDto.countryDto?.name.toString(),
            coordinates = String.format(
                "Latitude: %s, longitude: %s",
                binInfoDto.countryDto?.latitude,
                binInfoDto.countryDto?.longitude
            ),
            type = binInfoDto.type.toString(),
            url = binInfoDto.bank?.url.toString(),
            telephoneNumber = binInfoDto.bank?.phone.toString(),
            scheme = binInfoDto.scheme.toString(),
            name = binInfoDto.bank?.name.toString(),
            city = binInfoDto.bank?.city.toString()
        )
    }

    fun mapEntityToDbModel(binInfoItem: BinInfoItem): BinItemDbModel {
        return BinItemDbModel(
            binNumber = binInfoItem.binNumber,
            country = binInfoItem.country,
            coordinates = binInfoItem.coordinates,
            type = binInfoItem.type,
            city = binInfoItem.city,
            url = binInfoItem.url,
            telephoneNumber = binInfoItem.telephoneNumber,
            name = binInfoItem.name,
            scheme = binInfoItem.scheme
        )
    }

    fun mapDbModelToEntity(binInfoItem: BinItemDbModel): BinInfoItem {
        return BinInfoItem(
            binId = binInfoItem.id,
            binNumber = binInfoItem.binNumber,
            country = binInfoItem.country,
            coordinates = binInfoItem.coordinates,
            type = binInfoItem.type,
            url = binInfoItem.url,
            telephoneNumber = binInfoItem.telephoneNumber,
            name = binInfoItem.name,
            city = binInfoItem.city,
            scheme = binInfoItem.scheme
        )
    }

}