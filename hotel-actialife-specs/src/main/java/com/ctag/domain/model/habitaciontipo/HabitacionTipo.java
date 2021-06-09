package com.ctag.domain.model.habitaciontipo;

import java.util.List;

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

import com.ctag.domain.model.reservas.Reserva;
import com.ctag.paperless.utils.constants.Constants;

@Entity
@Table(name = HabitacionTipo.TABLE_NAME)
@IdClass(value = HabitacionTipoId.class)
public class HabitacionTipo extends BaseAggregateRoot<HabitacionTipoId> {

	public static final String TABLE_NAME = "habitacion_tipo";
	private static final String PK_ID = "id";
	private static final String GENERATOR = "HabTipoGen";
	private static final String MAPPED_BY = "habitacionTipo";
	private static final String FIELD_TIPO_HABITACION = "tipo_habitacion";
	private static final String FIELD_DESCRIPCION = "descripcion";
	private static final String FIELD_PRECIO = "precio";
	private static final String FIELD_M2 = "m2";
	private static final String FIELD_NUMERO_HABITACIONES = "numero_habitaciones";

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

	@Column(name = FIELD_TIPO_HABITACION)
	private String tipoHabitacion;

	@Column(name = FIELD_DESCRIPCION)
	private String descripcion;

	@Column(name = FIELD_PRECIO)
	private float precio;

	@Column(name = FIELD_M2)
	private float m2;

	@Column(name = FIELD_NUMERO_HABITACIONES)
	private Integer numeroHabitaciones;

	@OneToMany(mappedBy = MAPPED_BY, cascade = CascadeType.ALL)
	private List<Reserva> reservas;

	public String getTipo_habitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getM2() {
		return m2;
	}

	public void setM2(float m2) {
		this.m2 = m2;
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	@Override
	public HabitacionTipoId getId() {
		return new HabitacionTipoId(id);
	}

	protected HabitacionTipo() {
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
		HabitacionTipo castOther = (HabitacionTipo) other;
		return new EqualsBuilder().append(id, castOther.getId()).isEquals();
	}
}
