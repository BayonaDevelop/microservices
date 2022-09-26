package com.bayonasoftware.batteryplus.microservices.utils.model.entities.accumulators

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.logs.SubBrandLog
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "sub_brand", uniqueConstraints = [UniqueConstraint(columnNames = ["brand_id", "name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class SubBrand : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id")
  var brand: Brand? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:Column(name = "initials", nullable = false)
  var initials: String? = null

  @get:Column(name = "suffix", nullable = false)
  var suffix: String? = null

  @get:Column(name = "active")
  var active = false

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subBrand")
  var bciWarranties: MutableSet<BciWarranty>? = null

  /*@get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subbrand")
  var coverages: MutableSet<CoverageSubBrand>? = null*/

  @get:JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subBrand")
  var logs: MutableSet<SubBrandLog>? = null

}