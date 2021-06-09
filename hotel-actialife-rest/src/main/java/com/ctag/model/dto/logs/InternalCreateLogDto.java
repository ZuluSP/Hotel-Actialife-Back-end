package com.ctag.model.dto.logs;

import javax.validation.constraints.NotNull;

import org.seedstack.business.assembler.FactoryArgument;

import com.ctag.hotel.rest.model.LogsCreateDto;

public class InternalCreateLogDto extends LogsCreateDto {

  public InternalCreateLogDto(LogsCreateDto parent) {
    super(parent);
  }

  public InternalCreateLogDto() {}

  @FactoryArgument(index = 0)
  @Override
  public @NotNull Integer getIdUser() {
    return super.getIdUser();
  }

  @FactoryArgument(index = 1)
  @Override
  public @NotNull String getLog() {
    return super.getLog();
  }

  @FactoryArgument(index = 2)
  @Override
  public @NotNull String getTime() {
    return super.getTime();
  }
}
