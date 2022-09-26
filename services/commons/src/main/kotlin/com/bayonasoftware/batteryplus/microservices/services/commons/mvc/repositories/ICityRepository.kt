package com.bayonasoftware.batteryplus.microservices.services.commons.mvc.repositories

import com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.City
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ICityRepository : CrudRepository<City, Int> {

  @Query("SELECT new com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic.DropDownDTO(obj.id, obj.name) FROM City obj WHERE obj.country.id = :countryId")
  fun getForDDL(@Param("countryId") countryId: Int): MutableSet<DropDownDTO>

}
