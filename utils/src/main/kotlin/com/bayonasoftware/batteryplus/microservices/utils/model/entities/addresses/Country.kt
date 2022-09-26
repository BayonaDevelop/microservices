package com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(schema = "public", name = "country", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Country : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "code", length = 10)
  var code: String? = null

  @get:Column(name = "code_iso2", length = 10)
  var codeIso2: String? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "postal_code_regex")
  var postalCodeRegex: String? = null

  @get:Column(name = "sat_registry_regex")
  var satRegistryRegex: String? = null

  @get:Column(name = "region", length = 60)
  var reginon: String? = null

  @get:Column(name = "coat_of_arms")
  var coatOfArms: String? = null

  @get:Column(name = "flag")
  var flag: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
  var cities: MutableSet<Country>?= null

}
