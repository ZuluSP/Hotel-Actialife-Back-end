package com.ctag.model.dto.roles;

import javax.validation.constraints.NotNull;

import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.hotel.rest.model.RolecreateDto;

public class InternalRoleCreateDto extends RolecreateDto {

	public InternalRoleCreateDto(RolecreateDto parentDto) {
		super(parentDto);
	}

	public InternalRoleCreateDto() {

	}


	@FactoryArgument(index = 0)
	@Override
	public @NotNull String getNombreRol() {
		return super.getNombreRol();
	}

}
