package com.ctag.model.assembler.habitaciontipo;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;
import org.seedstack.seed.rest.internal.RestErrorCode;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.hotel.rest.model.HabitacionTipoDto;

public class HabitacionTipoAssembler extends BaseAssembler<HabitacionTipo, HabitacionTipoDto> {

	@Override
	public void mergeAggregateIntoDto(@Valid HabitacionTipo sourceAggregate, HabitacionTipoDto targetDto) {

		targetDto.setDescripcion(sourceAggregate.getDescripcion());
		targetDto.setPrecio(sourceAggregate.getPrecio());
		targetDto.setId(sourceAggregate.getId().getId());
		targetDto.setM2(sourceAggregate.getM2());
		targetDto.setNumeroHabitaciones(sourceAggregate.getNumeroHabitaciones());
		targetDto.setTipoHabitacion(sourceAggregate.getTipo_habitacion());

	}

	@Override
	public void mergeDtoIntoAggregate(@Valid HabitacionTipoDto sourceDto, HabitacionTipo targetAggregate) {
		throw new UnsupportedOperationException(RestErrorCode.CANNOT_MERGE_RESOURCE_WITH_DIFFERENT_REL.toString());
	}

}