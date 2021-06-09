package com.ctag.domain.model.habitaciontipo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;

@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class HabitacionTipoRepositoryIntegrationTest {

	private static final int ID = 1;

	private static final String TEST_STRING = "Test";

	private static final float TEST_FLOAT = 1;

	
	private HabitacionTipo underTest;

	@Inject
	private HabitacionTipoRepository repo;

	@Inject
	private HabitacionTipoFactory factory;

	@Test
	public void getAllRoomsTest() {

		underTest = factory.createHabitacionTipo(TEST_STRING, TEST_STRING, TEST_FLOAT, TEST_FLOAT, ID);

		List<HabitacionTipo> allRooms = new ArrayList<HabitacionTipo>();
		
		assertThat(allRooms).isEmpty();
		
		allRooms.add(underTest);

		assertThat(allRooms).isNotEmpty().hasSizeGreaterThanOrEqualTo(1);

	}

	@Test
	public void findHabitacionTipoByNameTest() {

		underTest = factory.createHabitacionTipo(TEST_STRING, TEST_STRING, TEST_FLOAT, TEST_FLOAT, ID);

		underTest.setTipoHabitacion(TEST_STRING);
		
		repo.add(underTest);

		List<HabitacionTipo> room = repo.findHabitacionTipoByName(TEST_STRING);

		assertThat(room.get(room.size()-1).getTipo_habitacion()).isEqualTo(underTest.getTipo_habitacion());

	}
}
