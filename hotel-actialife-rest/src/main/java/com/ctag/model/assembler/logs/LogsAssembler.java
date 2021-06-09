package com.ctag.model.assembler.logs;

import javax.validation.Valid;

import org.seedstack.business.assembler.BaseAssembler;
import org.seedstack.seed.rest.internal.RestErrorCode;

import com.ctag.domain.model.logs.LogCustom;
import com.ctag.hotel.rest.model.LogsDto;

public class LogsAssembler extends BaseAssembler<LogCustom, LogsDto> {

  @Override
  public void mergeAggregateIntoDto(LogCustom sourceAggregateRole, @Valid LogsDto targetDto) {

    targetDto.setId(sourceAggregateRole.getId().getId());
    targetDto.setIdUser(sourceAggregateRole.getId().getId());
    targetDto.setLog(sourceAggregateRole.getLog());
    targetDto.setTime(sourceAggregateRole.getTime());
  }

  @Override
  public void mergeDtoIntoAggregate(@Valid LogsDto sourceDto, LogCustom targetAggregate) {

    throw new UnsupportedOperationException(
        RestErrorCode.CANNOT_MERGE_RESOURCE_WITH_DIFFERENT_REL.toString());
  }
}
