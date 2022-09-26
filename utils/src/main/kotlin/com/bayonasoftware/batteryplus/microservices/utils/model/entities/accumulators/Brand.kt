package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.BrandLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "brand", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Brand : Serializable {

  @Serial
  var serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "initials", nullable = false)
  var initials: String? = null

  @get:Column(name = "own")
  var own = false

  @get:Column(name = "active")
  var active = false

  /*@get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  var subBrands: MutableSet<SubBrand>? = null*/

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  var bciWarranties: MutableSet<BciWarranty>? = null

  /*@get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  var coverages: MutableSet<CoverageBrand>? = null*/

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  var logs: MutableSet<BrandLog>? = null

}