package com.ctag.domain.model.reservas;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.UserId;

@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class ReservaRepositoryIntegrationTest {

	private static final int ID = 1;

	private static final LocalDate DATE_1 = LocalDate.of(2021, 2, 3);

	private static final LocalDate DATE_2 = LocalDate.of(2021, 3, 5);

	@Inject
	private ReservasRepository repo;
	@Inject
	private ReservasFactory factory;

	private Reserva underTest;

	@Test
	public void findReservaByIdTest() {
		underTest = factory.createReserva(new UserId(ID), DATE_2, DATE_1, new HabitacionTipoId(ID));

		repo.add(underTest);
		
		
		Reserva res = repo.findReservaById(new ReservasId(ID));

		assertThat(res.getId().getId()).isEqualTo(underTest.getId().getId());

	}

	@Test
	public void findReservasByUserIdTest() {
		underTest = factory.createReserva(new UserId(ID), DATE_2, DATE_1, new HabitacionTipoId(ID));

		repo.add(underTest);

		List<Reserva> reservas = repo.findReservasByUserId(underTest.getUserId());

		assertThat(reservas.get(reservas.size() - 1).getUserId()).isEqualTo(underTest.getUserId());

	}

	@Test
	public void findReservasByHabitacionTipoTest() {
		underTest = factory.createReserva(new UserId(ID), DATE_2, DATE_1, new HabitacionTipoId(ID));

		List<Reserva> reservas = repo.findReservasByHabitacionTipo(new HabitacionTipoId(ID));

		assertThat(reservas).isNotNull().contains(underTest);
		// underTest.getIdTipoHabitacion().getId()
	}

	@Test
	public void findReservasByDate() {
		underTest = factory.createReserva(new UserId(ID), DATE_2, DATE_1, new HabitacionTipoId(ID));

		underTest.setFechaInicio(DATE_1);

		underTest.setFechaFinal(DATE_2);

		repo.add(underTest);

		List<Reserva> reservas = repo.findReservasByDate(DATE_1, DATE_2);

		assertThat(reservas.get(reservas.size() - 1).getFechaInicio()).isEqualTo(underTest.getFechaInicio());
		assertThat(reservas.get(reservas.size() - 1).getFechaFinal()).isEqualTo(underTest.getFechaFinal());

	}

	@Test
	public void getAllReservasTest() {

		Integer EXPECTED_TEST = 1;

		List<Reserva> reservas = new ArrayList<Reserva>();

		reservas.add(underTest);

		assertThat(reservas).hasSizeGreaterThanOrEqualTo(EXPECTED_TEST);

	}

}
