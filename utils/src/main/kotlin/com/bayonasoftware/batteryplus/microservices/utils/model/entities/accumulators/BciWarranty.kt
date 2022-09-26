package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.BciWarrantyLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "bci_warranty", uniqueConstraints = [UniqueConstraint(columnNames = ["bci_base_id", "line_id", "brand_id", "sub_brand_id", "amperage"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class BciWarranty : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_base_id")
  var base: BciBase? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "line_id")
  var line: Line? = null

  @get:ManyToOne(fetch = FetchType.LAZY)
  @get:JoinColumn(name = "brand_id")
  var brand: Brand? = null

  @get:ManyToOne(fetch = FetchType.LAZY)
  @get:JoinColumn(name = "sub_brand_id")
  var subBrand: SubBrand? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "amperage", nullable = false)
  var amperage: String? = null

  @get:Column(name = "active")
  var active = false

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warranty")
  var accumulators: Set<Accumulator>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warranty")
  var logs: Set<BciWarrantyLog>? = null
}
