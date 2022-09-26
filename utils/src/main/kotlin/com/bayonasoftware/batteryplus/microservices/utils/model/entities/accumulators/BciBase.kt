package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.BciBaseLog
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
@Table(schema = "public", name = "bci_base", uniqueConstraints = [UniqueConstraint(columnNames = ["group_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class BciBase : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id")
  var grouper: Grouper? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "active")
  var active = false

  @get:JsonIgnore
  @get:OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  var used: MutableSet<BciUsed>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  var warranties: Set<BciWarranty>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  var coverages: Set<CoverageBciBase>? = null

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  var logs: Set<BciBaseLog>? = null

}
