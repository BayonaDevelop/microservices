package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "coverage_type", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class CoverageType : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  var coveragesBase: Set<CoverageBciBase>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  var coveragesBrand: Set<CoverageBrand>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  var coveragesSubBrand: Set<CoverageSubBrand>? = null

}