package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "bci_used", uniqueConstraints = [UniqueConstraint(columnNames = ["bci_base_id", "amperage"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class BciUsed : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_base_id")
  var base: BciBase? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "amperage", nullable = false)
  var amperage: String? = null

  @get:Column(name = "active")
  var active = false

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "used")
  var accumulators: MutableSet<Accumulator>? = null
  
}