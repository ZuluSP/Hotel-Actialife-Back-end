package com.ctag.domain.model.reservas;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class ReservasId extends BaseValueObject {

  private static final long serialVersionUID = 7771245994640117478L;

  private Integer id;

  public Integer getId() {
    return id;
  }

  protected ReservasId() {}

  public ReservasId(Integer id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
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
    ReservasId castOther = (ReservasId) other;
    return new EqualsBuilder().append(id, castOther.getId()).isEquals();
  }
}
