package com.ctag.domain.model.habitaciontipo;

import org.seedstack.business.domain.Factory;

public interface HabitacionTipoFactory extends Factory<HabitacionTipo> {

	HabitacionTipo createHabitacionTipo(String tipo_habitacion, String descripcion, float precio, float m2,
			Integer numero_habitaciones);
}