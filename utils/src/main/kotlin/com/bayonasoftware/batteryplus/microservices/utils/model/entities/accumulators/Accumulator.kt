package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.movements.MovementDetail
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

@Entity
@Table(schema = "public", name = "accumulator")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Accumulator : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_used_id")
  var used: BciUsed? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_warranty_id")
  var warranty: BciWarranty? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

  @get:Column(name = "previous_status")
  var previousStatus: Short = 0

  @get:Column(name = "status", nullable = false)
  var status: Short = 0

  @get:Column(name = "policy")
  var policy: String? = null

  @get:Column(name = "bill")
  var bill: String? = null

  @get:Column(name = "purchase_note")
  var purchaseNote: String? = null

  @get:Column(name = "voltage", precision = 16, nullable = false)
  var voltage: BigDecimal? = null

  @get:Column(name = "price", precision = 16, nullable = false)
  var price: BigDecimal? = null

  @get:Column(name = "taxi_driver", nullable = false)
  var taxiDriver = false

  @get:Column(name = "pressable", nullable = false)
  var pressable = false

  @get:Column(name = "borrowed", nullable = false)
  var borrowed = false

  @get:Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "admission_date", length = 23, nullable = false)
  var admissionDate: Date? = null

  @get:Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "policy_date", length = 23)
  var policyDate: Date? = null

  @get:Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "sale_date", length = 23)
  var saleDate: Date? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "accumulator")
  var details: MutableSet<MovementDetail>? = null

}
