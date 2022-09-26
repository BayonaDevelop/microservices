package com.bayonasoftware.batteryplus.microservices.utils.model.entities.movements

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators.Accumulator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable
import java.math.BigInteger


@Entity
@Table(schema = "public", name = "movement_detail", uniqueConstraints = [UniqueConstraint(columnNames = ["movement_id", "accumulator_id"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class MovementDetail : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movement_id")
  var movement: Movement? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "accumulator_id")
  var accumulator: Accumulator? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

}
