package com.ctag.model.assembler.habitaciontipo;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.model.dto.habitaciontipo.InternalHabitacionTipoCreateDto;

public class HabitacionTipoCreateAssembler extends BaseAssembler<HabitacionTipo, InternalHabitacionTipoCreateDto> {


	@Override
	public void mergeAggregateIntoDto(@Valid HabitacionTipo sourceAggregate, InternalHabitacionTipoCreateDto targetDto) {

		targetDto.setDescripcion(sourceAggregate.getDescripcion());
		targetDto.setPrecio(sourceAggregate.getPrecio());
		targetDto.setM2(sourceAggregate.getM2());
		targetDto.setNumeroHabitaciones(sourceAggregate.getNumeroHabitaciones());
		targetDto.setTipoHabitacion(sourceAggregate.getTipo_habitacion());

	}

	@Override
	public void mergeDtoIntoAggregate(@Valid InternalHabitacionTipoCreateDto sourceDto, HabitacionTipo targetAggregate) {

		targetAggregate.setDescripcion(sourceDto.getDescripcion());
		targetAggregate.setPrecio(sourceDto.getPrecio());
		targetAggregate.setM2(sourceDto.getM2());
		targetAggregate.setNumeroHabitaciones(sourceDto.getNumeroHabitaciones());
		targetAggregate.setTipoHabitacion(sourceDto.getTipoHabitacion());
   
	}
}
