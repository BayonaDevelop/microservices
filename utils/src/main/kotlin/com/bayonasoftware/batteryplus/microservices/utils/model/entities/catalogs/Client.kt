package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Address
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "public", name = "client")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Client : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  var address: Address? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "Code", length = 10)
  var code: String? = null

  @get:Column(name = "legal_name", nullable = false)
  var legalName: String? = null

  @get:Column(name = "commercial_name", nullable = false)
  var commercialName: String? = null

  @get:Column(name = "rfc")
  var rfc: String? = null

  @get:Column(name = "uso_cfdi")
  var usoCFDI: String? = null

  @get:Column(name = "email")
  var email: String? = null

  @get:Column(name = "classification")
  var classification: String? = null

  @get:Column(name = "seller")
  var seller: String? = null

  @get:Column(name = "has_vehicle_fleet")
  var vehicleFleet: String? = null

  @get:Column(name = "active", nullable = false)
  var active = false
}
