package com.ctag.model.assembler.reservas;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.hotel.rest.model.ReservasExtendedHabitacionTipoDto;
 
public class ReservasExtendedHabitacionTipoAssembler
		extends BaseAssembler<Reserva, ReservasExtendedHabitacionTipoDto> {
 
	public ReservasExtendedHabitacionTipoAssembler() {
 
	}
 
	public void mergeAggregateIntoDto(@Valid ReservasExtendedHabitacionTipoDto targetDto, Reserva sourceAggregate) {
 
		targetDto.setFechaInicio(sourceAggregate.getFechaInicio());
 
		targetDto.setFechaFin(sourceAggregate.getFechaFinal());
 
		targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());
 
	}
 
	public void mergeDtoIntoAggregate(Reserva targetAggregate, @Valid ReservasExtendedHabitacionTipoDto sourceDto) {
 
		targetAggregate.setIdTipoHabitacion(new HabitacionTipoId(sourceDto.getIdTipoHabitacion()));
 
		targetAggregate.setFechaInicio(sourceDto.getFechaInicio());
		targetAggregate.setFechaFinal(sourceDto.getFechaFin());
 
	}
 
}
