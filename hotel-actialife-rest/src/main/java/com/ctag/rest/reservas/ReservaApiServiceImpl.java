package com.ctag.rest.reservas;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.reservas.Reserva;
import com.ctag.domain.model.reservas.ReservasId;
import com.ctag.domain.model.reservas.ReservasRepository;
import com.ctag.hotel.rest.api.ReservaApiService;
import com.ctag.hotel.rest.model.ReservasCreateDto;
import com.ctag.hotel.rest.model.ReservasDto;
import com.ctag.hotel.rest.model.ReservasUpdateDto;
import com.ctag.model.dto.reservas.InternalReservasCreateDto;

@JpaUnit
@Transactional
public class ReservaApiServiceImpl implements ReservaApiService {

	private final ReservasRepository reservaRepo;
	private final FluentAssembler assembler;

	@Inject
	public ReservaApiServiceImpl(FluentAssembler assembler, ReservasRepository reservaRepo) {
		this.reservaRepo = reservaRepo;
		this.assembler = assembler;
	}

	@Override
	public Response deletereserva(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

		Reserva reserva = null;
		try {
			reserva = reservaRepo.get(new ReservasId(id))
					.orElseThrow(() -> new NotFoundException("Cannot find that reservation"));
		} catch (Exception e) {
			// FIXME: Exceptions are automatically mapped to the correct response
			return Response.noContent().build();
		}
		reservaRepo.remove(reserva);

		return Response.ok().build();
	}

	@Override
	public Response getReservaById(Integer id, SecurityContext securityContext, UriInfo uriInfo) {
		Reserva reserva = null;

		try {

			reserva = reservaRepo.get(new ReservasId(id))
					.orElseThrow(() -> new NotFoundException("Cannot find that reservation"));

		} catch (Exception e) {

			// FIXME: Exceptions are automatically mapped to the correct response
			return Response.noContent().build();
		}

		ReservasDto newDto = assembler.assemble(reserva).to(ReservasDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response createreserva(ReservasCreateDto body, SecurityContext securityContext,
			UriInfo uriInfo) {

		Reserva reserva = assembler
				.merge(new InternalReservasCreateDto(body))
				.into(Reserva.class)
				.fromFactory();

		ReservasDto newDto = assembler.assemble(reserva).to(ReservasDto.class);

		return Response.ok(newDto).build();
	}

	@Override
	public Response updatereserva(ReservasUpdateDto body, Integer id,
			SecurityContext securityContext, UriInfo uriInfo) {
		
		Reserva reserva = null;

		try {
			reserva = reservaRepo.get(new ReservasId(id))
					.orElseThrow(() -> new NotFoundException("Cannot find that Room Type"));
		} catch (Exception e) {
			
			// FIXME: Exceptions are automatically mapped to the correct response
			return Response.noContent().build();
		}

		assembler.merge(body).into(reserva);

		ReservasDto newDto = assembler.assemble(reserva).to(ReservasDto.class);

		return Response.ok(newDto).build();
	}

}
