package com.ctag.model.assembler.reservas;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.users.UserId;
import com.ctag.hotel.rest.model.ReservasDto;

public class ReservasAssembler extends BaseAssembler<Reserva, ReservasDto> {


	@Override
	public void mergeAggregateIntoDto(Reserva sourceAggregate, @Valid ReservasDto targetDto) {

		targetDto.setIdUser(sourceAggregate.getUserId().getId());

		targetDto.setFechaInicio(sourceAggregate.getFechaInicio());

		targetDto.setFechaFin(sourceAggregate.getFechaFinal());

		targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());

	}
	
	
	@Override
	public void mergeDtoIntoAggregate(@Valid ReservasDto sourceDto, Reserva targetAggregate) {
		// TODO Auto-generated method stub

		targetAggregate.setIdTipoHabitacion(new HabitacionTipoId(sourceDto.getIdTipoHabitacion()));
		
		targetAggregate.setFechaInicio(sourceDto.getFechaInicio());
		targetAggregate.setFechaFinal(sourceDto.getFechaFin());
		
		targetAggregate.setId_usuario(new UserId(sourceDto.getId()));
	}



}