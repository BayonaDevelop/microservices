package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.LineLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "line", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Line : Serializable {

  @Serial
  var serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "active")
  var active = false

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "line")
  var warranties: MutableSet<BciWarranty>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "line")
  var logs: MutableSet<LineLog>? = null

}