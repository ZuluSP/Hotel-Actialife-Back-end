package com.ctag.rest.reservas;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.reservas.ReservasRepository;
import com.ctag.domain.model.users.UserId;
import com.ctag.hotel.rest.api.ReservasApiService;
import com.ctag.hotel.rest.model.ReservasDto;

@JpaUnit
@Transactional
public class ReservasApiServiceImpl implements ReservasApiService {

	private final ReservasRepository reservaRepo;
	private final FluentAssembler assembler;

	@Inject
	public ReservasApiServiceImpl(FluentAssembler assembler, ReservasRepository reservaRepo) {
		this.reservaRepo = reservaRepo;
		this.assembler = assembler;
	}

	@Override
	public Response getReservaByHabitacionTipo(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

		List<Reserva> reservas = null;
		try {
			reservas = reservaRepo.findReservasByHabitacionTipo(new HabitacionTipoId(id));

		} catch (NotFoundException e) {
			throw new NotFoundException("Cannot find that reserva");
		}
		List<ReservasDto> newDto = assembler.assemble(reservas).toListOf(ReservasDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response getReservaByUserId(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

		List<Reserva> reservas = null;
		try {
			reservas = reservaRepo.findReservasByUserId(new UserId(id));

		} catch (NotFoundException e) {
			throw new NotFoundException("Cannot find that reserva");
		}
		List<ReservasDto> newDto = assembler.assemble(reservas).toListOf(ReservasDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response getReservas(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

		List<Reserva> reservas = reservaRepo.getAllReservas();
		List<ReservasDto> listDto = assembler.assemble(reservas).toListOf(ReservasDto.class);

		return Response.ok(listDto).build();

	}

}
