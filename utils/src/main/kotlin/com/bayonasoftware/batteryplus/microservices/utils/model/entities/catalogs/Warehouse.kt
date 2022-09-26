package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.addresses.Address
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.LineLog
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.WarehouseLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(schema = "public", name = "warehouse", uniqueConstraints = [UniqueConstraint(columnNames = ["commercial_branch_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Warehouse : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  var address: Address? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commercial_branch_id")
  var commercialBranch: CommercialBranch? = null

  @Id
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "active", nullable = false)
  var active = false


  @get:Column(name = "Latitude", precision = 16, scale = 10)
  var latitude: BigDecimal? = null

  @get:Column(name = "Longitude", precision = 16, scale = 10)
  var longitude: BigDecimal? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
  var logs: Set<WarehouseLog>? = null

}
