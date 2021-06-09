package com.ctag.domain.model.reservas;

import java.time.LocalDate;

import javax.inject.Inject;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.UserId;

public class ReservasFactoryImpl extends BaseFactory<Reserva> implements ReservasFactory {

	private final ReservasRepository repo;

	@Inject
	public ReservasFactoryImpl(ReservasRepository repo) {
		this.repo = repo;
	}

	@Override
	public Reserva createReservaAssembler(Integer idUser, LocalDate fechaInicio, LocalDate fechaFinal,
			Integer idHabitacionTipo) {

		return this.createReserva(new UserId(idUser), fechaInicio, fechaFinal, new HabitacionTipoId(idHabitacionTipo));

	}

	@Override
	public Reserva createReserva(UserId idUser, LocalDate fechaInicio, LocalDate fechaFinal,
			HabitacionTipoId idHabitacionTipo) {

		Reserva reserva = this.create();
		reserva.setId_usuario(idUser);
		reserva.setFechaInicio(fechaInicio);
		reserva.setFechaFinal(fechaFinal);
		reserva.setIdTipoHabitacion(idHabitacionTipo);
		// Esto se usa para agregarle el id y guardar en Base de Datos
		repo.add(reserva);

		return reserva;
	}

}
