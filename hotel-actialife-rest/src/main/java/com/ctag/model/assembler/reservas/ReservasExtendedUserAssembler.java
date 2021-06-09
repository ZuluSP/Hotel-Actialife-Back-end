package com.ctag.model.assembler.reservas;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.users.UserId;
import com.ctag.hotel.rest.model.ReservasCreateDto;
import com.ctag.hotel.rest.model.ReservasExtendedUserDto;
 
public class ReservasExtendedUserAssembler extends BaseAssembler<Reserva, ReservasExtendedUserDto> {
 
	public void mergeAggregateIntoDto(@Valid ReservasCreateDto targetDto, Reserva sourceAggregate) {
 
		targetDto.setIdUser(sourceAggregate.getId().getId());
 
		targetDto.setFechaInicio(sourceAggregate.getFechaInicio());
 
		targetDto.setFechaFin(sourceAggregate.getFechaFinal());
 
	}
 
	public void mergeDtoIntoAggregate(Reserva targetAggreReservas, @Valid ReservasCreateDto sourceDto) {
 
		targetAggreReservas.setId_usuario(new UserId(sourceDto.getIdUser()));
 
		targetAggreReservas.setFechaInicio(sourceDto.getFechaInicio());
 
		targetAggreReservas.setFechaFinal(sourceDto.getFechaFin());
 
	}
 
}