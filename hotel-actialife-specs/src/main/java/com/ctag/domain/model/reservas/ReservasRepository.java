package com.ctag.domain.model.reservas;

import java.time.LocalDate;
import java.util.List;

import org.seedstack.business.domain.Repository;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.UserId;
 
public interface ReservasRepository extends Repository<Reserva, ReservasId> {
 
	Reserva findReservaById(ReservasId id);
 
	List<Reserva> findReservasByUserId(UserId id);
 
	List<Reserva> findReservasByHabitacionTipo(HabitacionTipoId id);
 
	List<Reserva> findReservasByDate(LocalDate fechaInicio, LocalDate fechaFin);
	
	List<Reserva> getAllReservas();
}
