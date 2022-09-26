package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Address
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.movements.Movement
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth.User
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "public", name = "person")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Person : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  var address: Address? = null

  @get:JsonIgnore
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
  var user: User? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "last_name", nullable = false)
  var lastName: String? = null

  @get:Column(name = "second_last_name")
  var secondLastName: String? = null

  @get:Column(name = "ine")
  var ine: String? = null

  @get:Column(name = "driver_license")
  var driverLicense: String? = null

  @get:Column(name = "rfc")
  var rfc: String? = null

  @get:Column(name = "uso_cfdi")
  var usoCFDI: String? = null

  @get:Column(name = "email")
  var email: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  var telephones: MutableSet<Telephone>? = null

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  private val movements: MutableSet<Movement>? = null
}
