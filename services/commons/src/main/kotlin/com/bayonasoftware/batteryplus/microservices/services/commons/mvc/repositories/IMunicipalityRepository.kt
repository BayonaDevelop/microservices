package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories

import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Municipality
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IMunicipalityRepository : CrudRepository<Municipality, Int> {

  @Query("SELECT new com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO(obj.id, obj.name) FROM Municipality obj WHERE obj.city.id = :cityId")
  fun getForDDL(@Param("cityId") cityId: Int): MutableSet<DropDownDTO>

}
