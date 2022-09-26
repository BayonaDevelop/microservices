package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "public", name = "Telephone")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Telephone : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  var person: Person? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "number")
  var number: String? = null

  @get:Column(name = "extensions")
  var extensions: String? = null

}
