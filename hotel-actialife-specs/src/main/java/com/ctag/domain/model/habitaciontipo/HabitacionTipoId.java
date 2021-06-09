package com.ctag.domain.model.habitaciontipo;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.seedstack.business.domain.BaseValueObject;
 
@Embeddable
public class HabitacionTipoId extends BaseValueObject {
 
	/**
	 * GENERATED SERIAL VERSION
	 */
	private static final long serialVersionUID = 1376237322898005819L;
 
	private Integer id;
 
	protected HabitacionTipoId() {
 
	}
 
	public HabitacionTipoId(Integer id) {
		this.id = id;
	}
 
	public Integer getId() {
		return id;
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
		HabitacionTipoId castOther = (HabitacionTipoId) other;
		return new EqualsBuilder().append(id, castOther.getId()).isEquals();
	}
 
}
