package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.services

import com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories.IAddressRepository
import com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories.ICityRepository
import com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories.ILocationRepository
import com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories.IMunicipalityRepository
import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.addresses.AddressDTO
import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO
import com.example.commons.mvc.repositories.*
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class AddressService(
  val iCityRepository: ICityRepository,
  val iMunicipalityRepository: IMunicipalityRepository,
  val iLocationRepository: ILocationRepository,
  val iAddressRepository: IAddressRepository
) : IAddressService {

  override fun getCitiesForDDL(countryId: Int): List<DropDownDTO>
    = iCityRepository.getForDDL(countryId)

  override fun getMunicipalitiesForDDL(cityId: Int): List<DropDownDTO>
    = iMunicipalityRepository.getForDDL(cityId)

  override fun getLocationsForDDL(municipalityId: Int, label: String): List<DropDownDTO>
    = iLocationRepository.getForDDL(municipalityId, label)

  override fun create(param: AddressDTO) : BigInteger
    = iAddressRepository.create(
      param.municipalityId!!,
      param.location!!,
      param.zipCode!!,
      param.colony!!,
      param.street!!,
      param.street1!!,
      param.street2!!,
      param.internalNumber!!,
      param.externalNumber!!,
      param.reference!!
    )

  override fun getByID(addressId: Int) {
    TODO("Not yet implemented")
  }

}