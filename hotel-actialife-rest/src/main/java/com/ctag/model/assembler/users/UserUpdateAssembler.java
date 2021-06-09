package com.ctag.model.assembler.users;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.domain.model.users.User;
import com.ctag.hotel.rest.model.UserUpdateDto;
 
public class UserUpdateAssembler extends BaseAssembler<User, UserUpdateDto> {
 
 
 
	public UserUpdateAssembler() {
 
	}
 
	@Override
	public void mergeAggregateIntoDto(User sourceAggregate, @Valid UserUpdateDto targetDto) {
 
		targetDto.setUserId(sourceAggregate.getId().getId());
		targetDto.setRoleId(sourceAggregate.getRoleId().getId());
		targetDto.setAddress(sourceAggregate.getAddress());
		targetDto.setEmail(sourceAggregate.getEmail());
		targetDto.setName(sourceAggregate.getName());
		targetDto.setPassword(sourceAggregate.getPassword());
		targetDto.setSurname(sourceAggregate.getSurname());
		targetDto.setTelf(sourceAggregate.getTelf());
	}
 
	@Override
	public void mergeDtoIntoAggregate(@Valid UserUpdateDto sourceDto, User targetAggregate) {
 
		targetAggregate.setRoleId(new RolesCustomId(sourceDto.getRoleId()));
		targetAggregate.setAddress(sourceDto.getAddress());
		targetAggregate.setEmail(sourceDto.getEmail());
		targetAggregate.setName(sourceDto.getName());
		targetAggregate.setPassword(sourceDto.getPassword());
		targetAggregate.setSurname(sourceDto.getSurname());
		targetAggregate.setTelf(sourceDto.getTelf());
 
 
	}
 
}
