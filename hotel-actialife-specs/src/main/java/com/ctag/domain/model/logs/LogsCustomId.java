package com.ctag.domain.model.logs;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;

@Embeddable
public class LogsCustomId extends BaseValueObject {

  /** generated serialVersionUID */
  private static final long serialVersionUID = 1385507137714183621L;

  private Integer id;

  public LogsCustomId() {}

  public LogsCustomId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
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
    LogsCustomId castOther = (LogsCustomId) other;
    return new EqualsBuilder().append(id, castOther.id).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
  }
}
