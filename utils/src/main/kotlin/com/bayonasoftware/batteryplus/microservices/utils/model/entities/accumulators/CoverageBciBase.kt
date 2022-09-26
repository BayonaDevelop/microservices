package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "coverage_bci_base", uniqueConstraints = [UniqueConstraint(columnNames = ["coverage_type_id", "bci_base_id", "months_start", "months_end", "percentage"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class CoverageBciBase : Serializable {

  @Serial
  var serialVersionUID = 1L

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coverage_type_id")
  var type: CoverageType? = null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_base_id")
  var base: BciBase? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "months_start", nullable = false)
  var monthsStart: Short = 0

  @get:Column(name = "months_end", nullable = false)
  var monthsEnd: Short = 0

  @get:Column(name = "percentage", nullable = false)
  var percentage = 0f  

}
