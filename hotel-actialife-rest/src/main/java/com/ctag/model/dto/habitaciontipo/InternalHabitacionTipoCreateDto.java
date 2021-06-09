package com.ctag.model.dto.habitaciontipo;

import javax.validation.constraints.NotNull;

import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.hotel.rest.model.HabitacionTipoCreateDto;

public class InternalHabitacionTipoCreateDto extends HabitacionTipoCreateDto {

	public InternalHabitacionTipoCreateDto(HabitacionTipoCreateDto parent) {
		super(parent);
	}

	public InternalHabitacionTipoCreateDto() {

	}

	@FactoryArgument(index = 0)
	@Override
	public @NotNull String getTipoHabitacion() {
		return super.getTipoHabitacion();
	}

	@FactoryArgument(index = 1)
	@Override
	public String getDescripcion() {
		return super.getDescripcion();
	}

	@FactoryArgument(index = 2)
	@Override
	public @NotNull Float getPrecio() {
		return super.getPrecio();
	}

	@FactoryArgument(index = 3)
	@Override
	public Float getM2() {
		return super.getM2();
	}

	@FactoryArgument(index = 4)
	@Override
	public Integer getNumeroHabitaciones() {
		return super.getNumeroHabitaciones();
	}

}
