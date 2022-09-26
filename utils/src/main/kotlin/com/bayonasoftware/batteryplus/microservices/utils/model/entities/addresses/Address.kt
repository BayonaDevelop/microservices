package com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Client
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.CommercialBranch
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Person
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Warehouse
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType
import java.io.Serial
import java.io.Serializable
import java.util.Date


@Entity
@Table(schema = "public", name = "address")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Address : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id")
  var street: Street? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id_a")
  var streetA: Street? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id_b")
  var streetB: Street? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: Long? = null

  @get:Column(name = "Internal_Number", length = 60)
  var internalNumber: String? = null

  @get:Column(name = "External_Number", length = 60)
  var externalNumber: String? = null

  @get:Column(name = "Reference")
  var reference: String? = null

  @get:Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "creation_date", length = 23, nullable = false)
  var admissionDate: Date? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  var clients: MutableSet<Client>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  var people: MutableSet<Person>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  var commercialBranches: MutableSet<CommercialBranch>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  var warehouses: MutableSet<Warehouse>? = null
}
