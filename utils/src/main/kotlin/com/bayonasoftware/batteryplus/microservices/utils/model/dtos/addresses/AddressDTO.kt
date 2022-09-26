package com.bayonasoftware.batteryplus.microservices.utils.model.dtos.addresses

import java.io.Serial
import java.io.Serializable
import java.math.BigInteger

class AddressDTO : Serializable {

  @Serial
  private val serialVersionUID = 1L

  var id: BigInteger? = null

  var municipalityId: Int? = null

  var location: String? = null

  var zipCode: String? = null

  var colony: String? = null

  var street: String? = null

  var street1: String? = null

  var street2: String? = null

  var internalNumber: String? = null

  var externalNumber: String? = null

  var reference: String? = null

}