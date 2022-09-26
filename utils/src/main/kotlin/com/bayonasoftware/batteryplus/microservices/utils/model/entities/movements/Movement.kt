package com.bayonasoftware.batteryplus.microservices.utils.model.entities.movements

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Client
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Person
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.WarehouseSection
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth.User
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType
import java.io.Serial
import java.io.Serializable
import java.math.BigInteger
import java.util.Date


@Entity
@Table(schema = "public", name = "movement")
@JsonIgnoreProperties("hibernateLazyInitializer")
class Movement : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_section_origin_id", nullable = false)
  var origin: WarehouseSection? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_section_destination_id")
  var destination: WarehouseSection? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  var user: User? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_public_attention_id")
  var userPublicAttention: User? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  var client: Client? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  var person: Person? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: BigInteger? = null

  @get:Column(name = "type", nullable = false)
  var type: Short = 0

  @get:Column(name = "status", nullable = false)
  var status: Short = 0

  @Temporal(TemporalType.TIMESTAMP)
  @get:Column(name = "reception_date", length = 23, nullable = false)
  var receptionDate: Date? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "movement")
  var details: Set<MovementDetail>? = null
  
}