package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Address
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface IAddressRepository : CrudRepository<Address, BigInteger> {

  @Query(nativeQuery = true, value = "SELECT * FROM fn_address_add(" +
      ":municipalityId," +
      ":locationName," +
      ":zipCode," +
      ":colony," +
      ":street," +
      ":streetA," +
      ":streetB," +
      ":internalNumber," +
      ":externalNumber," +
      ":references" +
      ");")
  fun create(
    @Param("municipalityId") municipalityId: Int,
    @Param("locationName") locationName: String,
    @Param("zipCode") zipCode: String,
    @Param("colony") colony: String,
    @Param("street") street: String,
    @Param("streetA") streetA: String,
    @Param("streetB") streetB: String,
    @Param("internalNumber") internalNumber: String,
    @Param("externalNumber") externalNumber: String,
    @Param("references") references: String
  ) : BigInteger

}
