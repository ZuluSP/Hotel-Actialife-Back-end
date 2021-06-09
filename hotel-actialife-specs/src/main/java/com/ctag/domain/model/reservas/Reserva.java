package com.ctag.domain.model.reservas;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.seedstack.business.domain.BaseAggregateRoot;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.User;
import com.ctag.domain.model.users.UserId;
import com.ctag.paperless.utils.constants.Constants;

@Entity
@Table(name = Reserva.TABLE_NAME)
@IdClass(value = ReservasId.class)
public class Reserva extends BaseAggregateRoot<ReservasId> {

	public static final String TABLE_NAME = "reservas";
	private static final String FK_ID_USUARIO = "id_usuario";
	private static final String GENERATOR = "ReservasGen";
	private static final String FK_ID_TIPO_HABITACION = "id_tipo_habitacion";
	private static final String FECHA_INICIO = "fecha_inicio";
	private static final String FECHA_FINAL = "fecha_fin";
	private static final String PK_ID = "id";

	@TableGenerator(name = GENERATOR, table = Constants.SEQUENCE, pkColumnName = Constants.KEY_VAL, valueColumnName = Constants.VALUE, pkColumnValue = TABLE_NAME, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = GENERATOR)
	@Column(name = PK_ID, unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FK_ID_USUARIO, nullable = false, insertable = false, updatable = false)
	private User user;

	@Embedded
	@AttributeOverride(name = Constants.ID, column = @Column(name = FK_ID_USUARIO))
	private UserId userId;

	@Column(name = FECHA_INICIO)
	private LocalDate fechaInicio;

	@Column(name = FECHA_FINAL)
	private LocalDate fechaFinal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FK_ID_TIPO_HABITACION, nullable = false, insertable = false, updatable = false)
	private HabitacionTipo habitacionTipo;

	@Embedded
	@AttributeOverride(name = Constants.ID, column = @Column(name = FK_ID_TIPO_HABITACION))
	private HabitacionTipoId idTipoHabitacion;

	protected Reserva() {
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
		Reserva castOther = (Reserva) other;
		return new EqualsBuilder().append(id, castOther.getId()).isEquals();
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	@Override
	public ReservasId getId() {
		return new ReservasId(id);
	}

	public HabitacionTipoId getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public UserId getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setIdTipoHabitacion(HabitacionTipoId idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public void setId_usuario(UserId userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("user", user).append("id_usuario", userId)
				.append("fecha_inicio", fechaInicio).append("fecha_final", fechaFinal)
				.append("habitacionTipo", habitacionTipo).append("id_tipo_habitacion", idTipoHabitacion).toString();
	}
}
