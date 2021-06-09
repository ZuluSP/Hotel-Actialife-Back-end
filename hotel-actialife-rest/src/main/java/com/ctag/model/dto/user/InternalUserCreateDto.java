package com.ctag.model.dto.user;

import javax.validation.constraints.NotNull;

import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.hotel.rest.model.UsercreateDto;

public class InternalUserCreateDto extends UsercreateDto {

	public InternalUserCreateDto(UsercreateDto parent) {
		super(parent);
	}
	

	public InternalUserCreateDto() {

	}

	@FactoryArgument(index = 6)
	@Override
	public @NotNull Integer getRoleId() {
		return super.getRoleId();
	}

	@FactoryArgument(index = 0)
	@Override
	public @NotNull String getName() {
		return super.getName();
	}

	@FactoryArgument(index = 1)
	@Override
	public @NotNull String getSurname() {
		return super.getSurname();
	}

	@FactoryArgument(index = 2)
	@Override
	public @NotNull String getEmail() {
		return super.getEmail();
	}

	@FactoryArgument(index = 3)
	@Override
	public String getTelf() {
		return super.getTelf();
	}

	@FactoryArgument(index = 4)
	@Override
	public String getAddress() {
		return super.getAddress();
	}

	@FactoryArgument(index = 5)
	@Override
	public @NotNull String getPassword() {
		return super.getPassword();
	}
}
