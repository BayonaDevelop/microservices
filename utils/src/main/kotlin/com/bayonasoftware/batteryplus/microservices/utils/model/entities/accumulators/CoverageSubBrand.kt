package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "coverage_sub_brand", uniqueConstraints = [UniqueConstraint(columnNames = ["coverage_type_id", "sub_brand_id", "months_start", "months_end", "percentage"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class CoverageSubBrand : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coverage_type_id")
  private val type: CoverageType? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_brand_id")
  private val subbrand: SubBrand? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  private val id: Int? = null

  @get:Column(name = "months_start", nullable = false)
  private val monthsStart: Short = 0

  @get:Column(name = "months_end", nullable = false)
  private val monthsEnd: Short = 0

  @get:Column(name = "percentage", nullable = false)
  private val percentage = 0f

}