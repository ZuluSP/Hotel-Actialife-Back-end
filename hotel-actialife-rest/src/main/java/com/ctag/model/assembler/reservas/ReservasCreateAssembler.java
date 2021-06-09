package com.ctag.model.assembler.reservas;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.users.UserId;
import com.ctag.model.dto.reservas.InternalReservasCreateDto;

public class ReservasCreateAssembler extends BaseAssembler<Reserva, InternalReservasCreateDto> {

	/*
	@Override
	public void mergeAggregateIntoDto(Reserva sourceAggregate, @Valid InternalReservasCreateDto targetDto) {

		targetDto.setIdUser(sourceAggregate.getId().getId());

		targetDto.setFechaInicio(sourceAggregate.getFechaInicio());

		targetDto.setFechaFin(sourceAggregate.getFechaFinal());

		targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());

	}*/
	
	 @Override
	    public void mergeAggregateIntoDto(Reserva sourceAggregate, InternalReservasCreateDto targetDto) {
		 targetDto.setIdUser(sourceAggregate.getUserId().getId());
		 targetDto.setIdTipoHabitacion(sourceAggregate.getIdTipoHabitacion().getId());
		 targetDto.setFechaInicio(sourceAggregate.getFechaInicio());
		 targetDto.setFechaFin(sourceAggregate.getFechaFinal());
		 
		 
	    }

	@Override
	public void mergeDtoIntoAggregate(@Valid InternalReservasCreateDto sourceDto, Reserva targetAggreReservas) {

		targetAggreReservas.setId_usuario(new UserId(sourceDto.getIdUser()));

		targetAggreReservas.setIdTipoHabitacion(new HabitacionTipoId(sourceDto.getIdTipoHabitacion()));

		targetAggreReservas.setFechaInicio(sourceDto.getFechaInicio());

		targetAggreReservas.setFechaFinal(sourceDto.getFechaFin());

	}
}