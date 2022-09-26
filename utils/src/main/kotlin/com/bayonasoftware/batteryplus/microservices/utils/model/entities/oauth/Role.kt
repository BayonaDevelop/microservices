package com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable

@Entity
@Table(schema = "public", name = "app_role", uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class Role : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private val id: Int? = null

  @Column(name = "name", nullable = false)
  private val name: String? = null

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "app_users_roles",
    schema = "public",
    joinColumns = [JoinColumn(name = "role_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "user_id", nullable = false, updatable = false)]
  )
  private val users: MutableSet<User>? = null

}
