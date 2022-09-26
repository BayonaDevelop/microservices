package com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(schema = "public", name = "warehouse_section", uniqueConstraints = [UniqueConstraint(columnNames = ["warehouse_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class WarehouseSection : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_id")
  var warehouse: Warehouse? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null
}
