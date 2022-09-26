package com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*
import java.math.BigInteger

@Entity
@Table(schema = "public", name = "location")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Location : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "municipality_id")
  var municipality: Municipality? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

  @get:Column(name = "code", length = 10)
  var code: String? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
  var colonies: MutableSet<Colony>?= null

}
