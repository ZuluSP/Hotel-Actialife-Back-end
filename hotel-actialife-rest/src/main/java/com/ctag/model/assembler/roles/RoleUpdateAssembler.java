package com.ctag.model.assembler.roles;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.roles.RoleCustom;
import com.ctag.hotel.rest.model.RoleUpdateDto;
 
public class RoleUpdateAssembler extends BaseAssembler<RoleCustom, RoleUpdateDto> {
 
	public RoleUpdateAssembler() {
 
	}
 
	public void mergeAggregateIntoDto(@Valid RoleUpdateDto targetDto, RoleCustom sourceAggregate) {
 
		targetDto.setId(sourceAggregate.getId().getId());
 
		targetDto.setNombreRol(sourceAggregate.getNombreRol());
 
	}
 
	public void mergeDtoIntoAggregate(RoleCustom targetAggregate, @Valid RoleUpdateDto sourceDto) {
 
		targetAggregate.setNombreRol(sourceDto.getNombreRol());
 
	}
 
}
