package com.ctag.model.assembler.reservas;

import javax.inject.Inject;
import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.users.UserId;
import com.ctag.hotel.rest.model.ReservasUpdateDto;
 
public class ReservasUpdateAssembler extends BaseAssembler<Reserva, ReservasUpdateDto> {
 
	@Inject
	public ReservasUpdateAssembler() {
 
	}
 
	public void mergeAggregateIntoDto(@Valid ReservasUpdateDto targetDto, Reserva sourceAggregate) {
 
		targetDto.setId(sourceAggregate.getId().getId());
 
		targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());
 
		targetDto.setIdUser(sourceAggregate.getId().getId());
 
		targetDto.setFechaInicio(sourceAggregate.getFechaInicio());
 
		targetDto.setFechaFin(sourceAggregate.getFechaFinal());
 
		targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());
 
	}
 
	public void mergeDtoIntoAggregate(Reserva targetAggreReservas, @Valid ReservasUpdateDto sourceDto) {
 
		targetAggreReservas.setId_usuario(new UserId(sourceDto.getIdUser()));
 
		targetAggreReservas.setIdTipoHabitacion(new HabitacionTipoId(sourceDto.getIdTipoHabitacion()));
 
		targetAggreReservas.setFechaInicio(sourceDto.getFechaInicio());
 
		targetAggreReservas.setFechaFinal(sourceDto.getFechaFin());
 
	}
 
}
