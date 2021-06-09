package com.ctag.model.assembler.roles;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.roles.RoleCustom;
import com.ctag.model.dto.roles.InternalRoleCreateDto;

public class RolesCreateAssembler extends BaseAssembler<RoleCustom, InternalRoleCreateDto> {
	

	@Override
	public void mergeAggregateIntoDto(
			RoleCustom sourceAggregate, @Valid InternalRoleCreateDto targetDto) {

		targetDto.setNombreRol(sourceAggregate.getNombreRol());
	

	}
	

	@Override
	public void mergeDtoIntoAggregate(
			@Valid InternalRoleCreateDto sourceDto, RoleCustom targetAggregate) {

		targetAggregate.setNombreRol(sourceDto.getNombreRol());

	}

}
