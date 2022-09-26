package com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators.Accumulator
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators.BciBase
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators.Grouper
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators.Line
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth.User
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable
import java.math.BigInteger
import java.util.Date


@Entity
@Table(schema = "public", name = "line_log")
@JsonIgnoreProperties("hibernateLazyInitializer")
class LineLog : Serializable {

  @Serial
  private var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "entity_id", nullable = false)
  var entity: Line? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  var user: User? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

  @get:Column(name = "status", nullable = false)
  var status: Short = 0

  @Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "event_date", length = 23, nullable = false)
  var eventDate: Date? = null
  
}