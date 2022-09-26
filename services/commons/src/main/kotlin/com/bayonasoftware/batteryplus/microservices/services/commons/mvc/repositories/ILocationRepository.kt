package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories

import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Location
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ILocationRepository : CrudRepository<Location, BigInteger> {

  @Query("SELECT new com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO(obj.id, obj.name) FROM Location obj WHERE obj.municipality.id = :municipalityId AND obj.name = :label")
  fun getForDDL(@Param("municipalityId") municipalityId: Int, @Param("label") label: String): MutableSet<DropDownDTO>

}
