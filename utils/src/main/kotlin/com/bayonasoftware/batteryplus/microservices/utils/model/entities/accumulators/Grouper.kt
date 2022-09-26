package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.GrouperLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "grouper", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Grouper : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "letter", nullable = false)
  var letter: String? = null

  @get:Column(name = "color", nullable = false)
  var color: String? = null

  @get:Column(name = "active")
  var active = false

 /* @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "grouper")
  var bciBases: MutableSet<BciBase>? = null*/

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "grouper")
  var logs: MutableSet<GrouperLog>? = null

}