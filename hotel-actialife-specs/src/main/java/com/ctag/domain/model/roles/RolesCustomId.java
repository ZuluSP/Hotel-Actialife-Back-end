package com.ctag.domain.model.roles;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;
 
@Embeddable
public class RolesCustomId extends BaseValueObject {
 
  private static final long serialVersionUID = -926362561012771966L;
 
  private Integer id;
 
  public RolesCustomId(Integer id) {
    this.id = id;
  }
 
  protected RolesCustomId() {}
 
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
    RolesCustomId castOther = (RolesCustomId) other;
    return new EqualsBuilder().append(id, castOther.id).isEquals();
  }
 
  public Integer getId() {
    return id;
  }
 
  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
  }
}