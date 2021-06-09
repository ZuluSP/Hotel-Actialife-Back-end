package com.ctag.domain.model.users;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;
 
@Embeddable
public class UserId extends BaseValueObject {
 
  private static final long serialVersionUID = 6148349447698774799L;
  private Integer id;
 
  protected UserId() {}
 
  public UserId(Integer id) {
    this.id = id;
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
    UserId castOther = (UserId) other;
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