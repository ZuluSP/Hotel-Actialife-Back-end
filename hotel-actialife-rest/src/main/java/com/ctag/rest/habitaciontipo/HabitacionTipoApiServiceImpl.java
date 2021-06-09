package com.ctag.rest.habitaciontipo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoRepository;
import com.ctag.hotel.rest.api.HabitacionTipoApiService;
import com.ctag.hotel.rest.model.HabitacionTipoCreateDto;
import com.ctag.hotel.rest.model.HabitacionTipoDto;
import com.ctag.hotel.rest.model.HabitacionTipoUpdateDto;
import com.ctag.model.dto.habitaciontipo.InternalHabitacionTipoCreateDto;
import com.ctag.paperless.utils.exceptions.jpa.persistance.CannotFindException;
import com.ctag.paperless.utils.rest.response.PaperlessResponse;
import com.ctag.paperless.utils.rest.response.PaperlessResponseException;

@JpaUnit
@Transactional
public class HabitacionTipoApiServiceImpl implements HabitacionTipoApiService {

	private final HabitacionTipoRepository roomRepo;
	private final FluentAssembler assembler;

	@Inject
	public HabitacionTipoApiServiceImpl(FluentAssembler assembler, HabitacionTipoRepository roomRepo) {
		this.roomRepo = roomRepo;
		this.assembler = assembler;

	}

	@Override
	public Response createHabitacionTipo(HabitacionTipoCreateDto body, SecurityContext securityContext,
			UriInfo uriInfo) {

		HabitacionTipo roomType = assembler. 
				merge(new InternalHabitacionTipoCreateDto(body))
				.into(HabitacionTipo.class)
				.fromFactory();

		HabitacionTipoDto newDto = assembler
				.assemble(roomType)
				.to(HabitacionTipoDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response deleteHabitacionTipo(Integer id, SecurityContext securityContext, UriInfo uriInfo) {
		HabitacionTipo room = null;

		try {
			room = roomRepo.get(new HabitacionTipoId(id))
					.orElseThrow(() -> new NotFoundException("Cannot find that Room Type"));
		} catch (Exception e) {
			return Response.noContent().build();
		}

		roomRepo.remove(room);

		return Response.ok().build();
	}

	@Override
	public Response getHabitacionTipoById(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

		try {
			return PaperlessResponse.with(
					assembler.assemble(roomRepo.getOrException(new HabitacionTipoId(id))).to(HabitacionTipoDto.class));
		} catch (CannotFindException e) {
			throw new PaperlessResponseException(e, Status.NOT_FOUND);
		}
	}

	@Override
	public Response updateHabitacionTipo(HabitacionTipoUpdateDto body, Integer id, SecurityContext securityContext,
			UriInfo uriInfo) {
		HabitacionTipo room = null;

		try {
			room = roomRepo.get(new HabitacionTipoId(id))
					.orElseThrow(() -> new NotFoundException("Cannot find that Room Type"));
		} catch (Exception e) {

			// FIXME: Exceptions are automatically mapped to the correct response
			return Response.noContent().build();
		}

		assembler.merge(body).into(room);

		HabitacionTipoDto newDto = assembler.assemble(room).to(HabitacionTipoDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response getAllRooms(SecurityContext securityContext, UriInfo uriInfo) {

		List<HabitacionTipo> rooms = roomRepo.getAllRooms();
		List<HabitacionTipoDto> listDto = assembler.assemble(rooms).toListOf(HabitacionTipoDto.class);

		return Response.ok(listDto).build();
	}
}
