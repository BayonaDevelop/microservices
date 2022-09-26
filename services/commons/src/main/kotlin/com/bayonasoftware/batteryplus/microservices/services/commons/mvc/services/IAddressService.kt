package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.services

import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.addresses.AddressDTO
import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO
import java.math.BigInteger

interface IAddressService {

  fun getCitiesForDDL(countryId: Int) : MutableSet<DropDownDTO>

  fun getMunicipalitiesForDDL(cityId: Int) : MutableSet<DropDownDTO>

  fun getLocationsForDDL(municipalityId: Int, label: String) : MutableSet<DropDownDTO>

  fun create(param: AddressDTO): BigInteger

  fun getByID(addressId: Int)

}
