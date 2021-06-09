package com.ctag.model.dto.reservas;

import java.time.LocalDate;

import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.hotel.rest.model.ReservasCreateDto;

public class InternalReservasCreateDto extends ReservasCreateDto {

	protected InternalReservasCreateDto() {
		
	}

	public InternalReservasCreateDto(ReservasCreateDto parentDto) {
		super(parentDto);
	}

	@FactoryArgument(index = 0)
	@Override
	public Integer getIdUser() {
		return super.getIdUser();
	}
	
	@FactoryArgument(index = 1)
	@Override
	public LocalDate getFechaInicio() {
		return super.getFechaInicio();
	}
	
	@FactoryArgument(index = 2)
	@Override
	public LocalDate getFechaFin() {
		return super.getFechaFin();
	}
	
	@FactoryArgument(index = 3)
	@Override
	public Integer getIdTipoHabitacion() {
		return super.getIdTipoHabitacion();
	}
}
