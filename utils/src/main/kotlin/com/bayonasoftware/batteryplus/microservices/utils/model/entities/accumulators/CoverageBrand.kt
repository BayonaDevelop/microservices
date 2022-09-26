package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "coverage_brand")
@JsonIgnoreProperties("hibernateLazyInitializer")
class CoverageBrand : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coverage_type_id")
  private val type: CoverageType? = null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id")
  private val brand: Brand? = null

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