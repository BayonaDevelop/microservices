package com.bayonasoftware.batteryplus.microservices.utils.model.entities.oauth

import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.CommercialBranch
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.catalogs.Person
import com.bayonasoftware.batteryplus.microservices.utils.model.entities.movements.Movement
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serial
import java.io.Serializable


@Entity
@Table(schema = "public", name = "app_user", uniqueConstraints = [UniqueConstraint(columnNames = ["username"])])
@JsonIgnoreProperties("hibernateLazyInitializer")
class User : Serializable {

  @Serial
  private val serialVersionUID = 1L

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  private val person: Person? = null

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commercial_branch_id", nullable = false)
  private val commercialBranch: CommercialBranch? = null

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private val id: Int? = null

  @Column(name = "username", nullable = false)
  private val username: String? = null

  @Column(name = "name", nullable = false)
  private val password: String? = null

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "app_users_roles",
    schema = "public",
    joinColumns = [JoinColumn(name = "user_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "role_id", nullable = false, updatable = false)]
  )
  private val roles: MutableSet<Role>? = null

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private val movements: MutableSet<Movement>? = null

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userPublicAttention")
  private val movementsAttended: MutableSet<Movement>? = null

}
