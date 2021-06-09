package com.ctag.model.assembler.logs;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;

import com.ctag.domain.model.logs.LogCustom;
import com.ctag.domain.model.users.UserId;
import com.ctag.model.dto.logs.InternalCreateLogDto;

public class LogsCreateAssembler extends BaseAssembler<LogCustom, InternalCreateLogDto> {

  @Override
  public void mergeAggregateIntoDto(
      LogCustom sourceAggregate, @Valid InternalCreateLogDto targetDto) {

    targetDto.setIdUser(sourceAggregate.getId().getId());

    targetDto.setLog(sourceAggregate.getLog());

    targetDto.setTime(sourceAggregate.getTime());
  }

  @Override
  public void mergeDtoIntoAggregate(
      @Valid InternalCreateLogDto sourceDto, LogCustom targetAggregate) {

    targetAggregate.setLog(sourceDto.getLog());

    targetAggregate.setTime(sourceDto.getTime());

    targetAggregate.setUserId(new UserId(sourceDto.getIdUser()));
  }
}
