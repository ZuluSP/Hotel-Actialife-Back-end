package com.ctag.domain.model.roles;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseAggregateRoot;

import com.ctag.domain.model.users.User;
import com.ctag.paperless.utils.constants.Constants;


@Entity
@Table(name = RoleCustom.TABLE_NAME)
@IdClass(value = RolesCustomId.class)
public class RoleCustom extends BaseAggregateRoot<RolesCustomId> {

  public static final String TABLE_NAME = "roles";
  private static final String GENERATOR = "RolesGen";
  private static final String MAPPED_BY = "roles";
  private static final String PK_ID = "id";
  private static final String ROL_NAME = "nombre_rol";

  @TableGenerator(
      name = GENERATOR,
      table = Constants.SEQUENCE,
      pkColumnName = Constants.KEY_VAL,
      valueColumnName = Constants.VALUE,
      pkColumnValue = TABLE_NAME,
      allocationSize = 1)
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = GENERATOR)
  @Column(name = PK_ID, unique = true, nullable = false)
  private Integer id;

  @Column(name = ROL_NAME)
  private String nombreRol;

  @OneToMany(mappedBy = MAPPED_BY, cascade = CascadeType.ALL)
  private Set<User> users;

  public RoleCustom() {}

  public void addUsers(User users) {
    if (this.users == null) {
      this.users = new HashSet<User>();
    }
    this.users.add(users);
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (!getClass().equals(other.getClass())) {
      return false;
    }
    RoleCustom castOther = (RoleCustom) other;
    return new EqualsBuilder().append(id, castOther.getId()).isEquals();
  }
  @Override
  public RolesCustomId getId() {
    return new RolesCustomId(id);
  }

  public String getNombreRol() {
    return nombreRol;
  }

  public Set<User> getUsers() {

    if (this.users == null) {
      return Collections.emptySet();
    }

    return Collections.unmodifiableSet(users);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
  }

  public void setNombreRol(String nombreRol) {
    this.nombreRol = nombreRol;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "RoleCustom [id=" + id + ", nombreRol=" + nombreRol + ", users=" + users + "]";
  }
}
