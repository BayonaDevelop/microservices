package com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(schema = "public", name = "app_role", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Role {

  @get:Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  var id: Int? = null

  @get:Column(name = "name", nullable = false)
  var name: String? = null

  @get:JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "app_users_roles",
    schema = "public",
    joinColumns = [JoinColumn(name = "role_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "user_id", nullable = false, updatable = false)]
  )
  var users: Set<User>? = null
}