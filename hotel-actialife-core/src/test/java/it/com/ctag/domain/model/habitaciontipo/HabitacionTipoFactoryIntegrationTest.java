package com.ctag.domain.model.habitaciontipo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;


@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class HabitacionTipoFactoryIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final String TEST_STRING = "test";
	  private static final Long INITIAL_EXPECTED_CONTROL_RESULTS = 10L;
	  private static final Long EXPECTED_CONTROL_RESULTS = 11L;
	


	@Inject
	private HabitacionTipoFactory factory;
	@Inject
	private HabitacionTipoRepository repository;

	@Test
	public void createHabitacionTipo() throws Exception {
		
		validateAllHabitacionTipo(INITIAL_EXPECTED_CONTROL_RESULTS);
		
		HabitacionTipo createRoom = 
				factory.createHabitacionTipo(TEST_STRING,TEST_STRING, 0f, 0f, TEST_INTEGER);
	    
		validateAllHabitacionTipo(EXPECTED_CONTROL_RESULTS);
		
		assertThat(createRoom.getDescripcion()).isEqualTo(TEST_STRING);
		assertThat(createRoom.getM2()).isEqualTo(0f);
		assertThat(createRoom.getPrecio()).isEqualTo(0f);
		assertThat(createRoom.getNumeroHabitaciones()).isEqualTo(TEST_INTEGER);
		assertThat(createRoom.getTipo_habitacion()).isEqualTo(TEST_STRING);
		
	}
	  public void validateAllHabitacionTipo(Long expected) {
		    Long before =
		        repository
		            .get(repository.getSpecificationBuilder().of(HabitacionTipo.class).all().build())
		            .count();
		    assertThat(before).isEqualTo(expected);
		  }
	  
}
