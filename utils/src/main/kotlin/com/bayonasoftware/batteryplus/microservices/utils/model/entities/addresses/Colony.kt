package com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import java.io.Serial
import java.io.Serializable
import java.math.BigInteger

@Entity
@Table(schema = "public", name = "colony")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Colony : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  var location: Location? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

  @get:Column(name = "zip_code", length = 20)
  var zipCode: String? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "colony")
  var streets: MutableSet<Street>?= null

}
