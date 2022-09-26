package com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "public", name = "municipality", uniqueConstraints = [UniqueConstraint(columnNames = ["city_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Municipality : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "city_id")
  var city: City? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "code", length = 10)
  var code: String? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "coat_of_arms")
  var coatOfArms: String? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
  var locations: MutableSet<Location>?= null

}
