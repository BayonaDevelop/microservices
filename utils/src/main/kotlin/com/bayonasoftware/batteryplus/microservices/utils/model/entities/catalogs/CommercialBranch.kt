package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Address
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth.User
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(schema = "public", name = "commercial_branch")
@JsonIgnoreProperties("hibernateLazyInitializer")
class CommercialBranch : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  var address: Address? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "matrix_id", nullable = false)
  var matrix: CommercialBranch? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "legal_name", nullable = false)
  var legalName: String? = null

  @get:Column(name = "commercial_name", nullable = false)
  var commercialName: String? = null

  @get:Column(name = "rfc")
  var rfc: String? = null

  @get:Column(name = "active")
  var active = false

  @get:Column(name = "main")
  var main = false

  @get:Column(name = "Latitude", precision = 16, scale = 10)
  var latitude: BigDecimal? = null

  @get:Column(name = "Longitude", precision = 16, scale = 10)
  var longitude: BigDecimal? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "commercialBranch")
  var users: MutableSet<User>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "commercialBranch")
  var warehouses: MutableSet<Warehouse>? = null
}
