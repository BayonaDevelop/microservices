package com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.CommercialBranch
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Person
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serial
import java.io.Serializable
import javax.persistence.*


@Entity
@Table(schema = "public", name = "app_user", uniqueConstraints = [UniqueConstraint(columnNames = ["username"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class User : Serializable {

  @Serial
  var serialVersionUID = 1L

  @get:JsonIgnore
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  var person: Person? = null

  @get:JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commercial_branch_id", nullable = false)
  var commercialBranch: CommercialBranch? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @get:Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "username", nullable = false)
  var username: String? = null

  @get:Column(name = "name", nullable = false)
  var password: String? = null

  @get:JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "app_users_roles",
    schema = "public",
    joinColumns = [JoinColumn(name = "user_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "role_id", nullable = false, updatable = false)]
  )
  var roles: Set<Role>? = null
  
}
