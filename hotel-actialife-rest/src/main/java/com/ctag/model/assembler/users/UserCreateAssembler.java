package com.ctag.model.assembler.users;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.domain.model.users.User;
import com.ctag.model.dto.user.InternalUserCreateDto;

public class UserCreateAssembler extends BaseAssembler<User, InternalUserCreateDto> {

	@Override
	public void mergeAggregateIntoDto(User sourceAggregate, @Valid InternalUserCreateDto targetDto) {

		targetDto.setRoleId(sourceAggregate.getRoleId().getId());
		targetDto.setAddress(sourceAggregate.getAddress());
		targetDto.setEmail(sourceAggregate.getEmail());
		targetDto.setName(sourceAggregate.getName());
		targetDto.setPassword(sourceAggregate.getPassword());
		targetDto.setSurname(sourceAggregate.getSurname());
		targetDto.setTelf(sourceAggregate.getTelf());
	}

	@Override
	public void mergeDtoIntoAggregate(@Valid InternalUserCreateDto sourceDto, User targetAggregate) {

		
		targetAggregate.setAddress(sourceDto.getAddress());
		targetAggregate.setEmail(sourceDto.getEmail());
		targetAggregate.setName(sourceDto.getName());
		targetAggregate.setPassword(sourceDto.getPassword());
		targetAggregate.setSurname(sourceDto.getSurname());
		targetAggregate.setTelf(sourceDto.getTelf());
		targetAggregate.setRoleId(new RolesCustomId(sourceDto.getRoleId()));
	}
}