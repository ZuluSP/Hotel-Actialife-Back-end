package com.ctag.rest.logs;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.logs.LogCustom;
import com.ctag.domain.model.logs.LogsCustomId;
import com.ctag.domain.model.logs.LogsRepository;
import com.ctag.domain.model.users.UserId;
import com.ctag.hotel.rest.api.LogsApiService;
import com.ctag.hotel.rest.model.LogsCreateDto;
import com.ctag.hotel.rest.model.LogsDto;
import com.ctag.hotel.rest.model.LogsUpdateDto;
import com.ctag.model.dto.logs.InternalCreateLogDto;

@JpaUnit
@Transactional
public class LogsApiServiceImpl implements LogsApiService {

  private final LogsRepository logsRepo;
  private final FluentAssembler assembler;

  @Inject
  public LogsApiServiceImpl(LogsRepository logsRepo, FluentAssembler assembler) {
    this.logsRepo = logsRepo;
    this.assembler = assembler;
  }

  @Override
  public Response createLog(LogsCreateDto body, SecurityContext securityContext, UriInfo uriInfo) {
    LogCustom log =
        assembler.merge(new InternalCreateLogDto(body)).into(LogCustom.class).fromFactory();

    return Response.ok(assembler.assemble(log).to(LogsDto.class)).build();
  }

  @Override
  public Response deleteLog(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

    LogCustom log = null;

    try {

      log =
          logsRepo
              .get(new LogsCustomId(id))
              .orElseThrow(() -> new NotFoundException("Cannot find that log"));

    } catch (Exception e) {
      // FIXME: Exceptions are automatically mapped to the correct response
      return Response.noContent().build();
    }

    logsRepo.remove(log);

    return Response.ok().build();
  }

  @Override
  public Response getAllLogs(SecurityContext securityContext, UriInfo uriInfo) {

    List<LogCustom> logs = logsRepo.getAllLogs();

    List<LogsDto> logsDto = assembler.assemble(logs).toListOf(LogsDto.class);

    return Response.ok(logsDto).build();
  }

  @Override
  public Response getLogsByUserId(
      Integer idUser, SecurityContext securityContext, UriInfo uriInfo) {
    List<LogCustom> logs = null;
    try {
      logs = logsRepo.findLogsByUser(new UserId(idUser));

    } catch (Exception e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped
      // to the correct
      // response
      Response.noContent().build();
    }

    List<LogsDto> logsDto = assembler.assemble(logs).toListOf(LogsDto.class);

    return Response.ok(logsDto).build();
  }

  @Override
  public Response updateLog(
      LogsUpdateDto body, Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    LogCustom log = null;
    try {
      log =
          logsRepo
              .get(new LogsCustomId(id))
              .orElseThrow(() -> new NotFoundException("Log not found"));

    } catch (Exception e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped
      // to the correct
      // response
      Response.noContent().build();
    }

    assembler.merge(body).into(log);

    LogsDto newDto = assembler.assemble(log).to(LogsDto.class);

    return Response.ok(newDto).build();
  }
}
