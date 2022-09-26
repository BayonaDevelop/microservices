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
import javax.persistence.UniqueConstraint
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "city", uniqueConstraints = [UniqueConstraint(columnNames = ["country_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class City : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  var country: Country? = null

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
  var municipalities: MutableSet<Municipality>?= null

}
