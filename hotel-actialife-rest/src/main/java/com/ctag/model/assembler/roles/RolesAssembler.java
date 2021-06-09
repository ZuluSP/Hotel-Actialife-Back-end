package com.ctag.model.assembler.roles;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;
import org.seedstack.seed.rest.internal.RestErrorCode;

import com.ctag.domain.model.roles.RoleCustom;
import com.ctag.hotel.rest.model.RoleDto;

public class RolesAssembler extends BaseAssembler<RoleCustom, RoleDto> {
	
	@Override
	public void mergeAggregateIntoDto(RoleCustom sourceAggregateRole, @Valid RoleDto targetDto) {
 
		targetDto.setId(sourceAggregateRole.getId().getId()); 
		targetDto.setNombreRol(sourceAggregateRole.getNombreRol());
	}
 

	@Override
	public void mergeDtoIntoAggregate(@Valid RoleDto sourceDto, RoleCustom targetAggregate) {
		
		throw new UnsupportedOperationException(RestErrorCode.CANNOT_MERGE_RESOURCE_WITH_DIFFERENT_REL.toString());
	}

}
