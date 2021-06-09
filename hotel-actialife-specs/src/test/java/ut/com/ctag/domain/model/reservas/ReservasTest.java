package com.ctag.domain.model.reservas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.User;
import com.ctag.domain.model.users.UserId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ReservasTest {

	private static final Integer TEST_INTEGER = 1;

	private static final LocalDate TEST_DATE = LocalDate.parse("2017-11-10");
	private static final String PK_ID = "id";

	private HabitacionTipoId id_habitacionTest = new HabitacionTipoId(TEST_INTEGER);

	private UserId idUserTest = new UserId(TEST_INTEGER);

	private Reserva underTest = new Reserva();

	@Test
	public void testEmptyConstructor() {
		underTest = new Reserva();
		assertNotNull(underTest);
	}

	@Test
	public void testEquals() throws Exception {

		EqualsVerifier.forClass(Reserva.class).withRedefinedSuperclass().usingGetClass()
				.withPrefabValues(User.class, mock(User.class), mock(User.class))
				.withPrefabValues(HabitacionTipo.class, mock(HabitacionTipo.class), mock(HabitacionTipo.class))
				.suppress(Warning.SURROGATE_KEY).verify();
	}

	@Test
	public void testGetFechaFinal() {
		underTest.setFechaFinal(TEST_DATE);
		assertThat(underTest.getFechaFinal()).isEqualTo(TEST_DATE);
	}

	@Test
	public void testGetFechaInicio() {
		underTest.setFechaInicio(TEST_DATE);

		assertThat(underTest.getFechaInicio()).isEqualTo(TEST_DATE);
	}

	@Test
	public void testGetId() throws Exception {
		Plugins.getMemberAccessor().set(Reserva.class.getDeclaredField(PK_ID), this.underTest, TEST_INTEGER);
		this.underTest.getId();

		assertThat(underTest.getId().getId()).isEqualTo(TEST_INTEGER);
	}

	@Test
	public void testGetId_tipo_habitacion() throws Exception {
		underTest.setIdTipoHabitacion(id_habitacionTest);
		assertThat(underTest.getIdTipoHabitacion()).isEqualTo(id_habitacionTest);
	}

	@Test
	public void testGetId_usuario() throws Exception {
		underTest.setId_usuario(idUserTest);
		assertThat(underTest.getUserId()).isEqualTo(idUserTest);
	}

	@Test
	public void testToString() throws Exception {

		underTest.setIdTipoHabitacion(id_habitacionTest);
		underTest.setId_usuario(idUserTest);
		underTest.setFechaFinal(TEST_DATE);
		underTest.setFechaInicio(TEST_DATE);

		assertThat(underTest.toString()).contains(TEST_DATE.toString()).contains(id_habitacionTest.toString())
				.contains(idUserTest.getId().toString());
	}
}
