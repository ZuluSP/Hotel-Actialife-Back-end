

package com.ctag.model.assembler.users;


import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;
import org.seedstack.seed.rest.internal.RestErrorCode;

import com.ctag.domain.model.users.User;
import com.ctag.hotel.rest.model.UserDto;
 
public class UserAssembler extends BaseAssembler<User, UserDto> {
 
	@Override
	public void mergeAggregateIntoDto(@Valid User sourceAggregateUser, UserDto targetDto) {
 
		targetDto.setUserId(sourceAggregateUser.getId().getId());
		targetDto.setRoleId(sourceAggregateUser.getRoleId().getId());
 
		targetDto.setName(sourceAggregateUser.getName());
		targetDto.setSurname(sourceAggregateUser.getSurname());
		targetDto.setAddress(sourceAggregateUser.getAddress());
		targetDto.setTelf(sourceAggregateUser.getTelf());
		targetDto.setPassword(sourceAggregateUser.getPassword());
		targetDto.setEmail(sourceAggregateUser.getEmail());
 
	}
 
	@Override
	public void mergeDtoIntoAggregate(@Valid UserDto sourceDto, User targetAggregate) {
		throw new UnsupportedOperationException(RestErrorCode.CANNOT_MERGE_RESOURCE_WITH_DIFFERENT_REL.toString());
	}
 
}
