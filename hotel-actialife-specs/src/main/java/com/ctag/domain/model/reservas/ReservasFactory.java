package com.ctag.domain.model.reservas;

import java.time.LocalDate;

import org.seedstack.business.domain.Factory;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.UserId;

public interface ReservasFactory extends Factory<Reserva> {

	Reserva createReservaAssembler(Integer idUser, LocalDate fechaInicio, LocalDate fechaFinal, Integer idHabitacionTipo);

	Reserva createReserva(UserId idUser, LocalDate fechaInicio, LocalDate fechaFinal,
			HabitacionTipoId idHabitacionTipo);

}
