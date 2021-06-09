package com.ctag.domain.model.reservas;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;


@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class ReservaFactoryIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final LocalDate TEST_DATE = LocalDate.of(2020, Month.JANUARY, 18);
	  private static final Long INITIAL_EXPECTED_CONTROL_RESULTS = 11L;
	  private static final Long EXPECTED_CONTROL_RESULTS = 12L;
	


	@Inject
	private ReservasFactory factory;
	@Inject
	private ReservasRepository repository;

	@Test
	public void createHabitacionTipo() throws Exception {
		
		validateAllReservas(INITIAL_EXPECTED_CONTROL_RESULTS);
		
		Reserva createReserva = 
				factory.createReservaAssembler(TEST_INTEGER, TEST_DATE,TEST_DATE,TEST_INTEGER);
	    
		validateAllReservas(EXPECTED_CONTROL_RESULTS);
		
		
		assertThat(createReserva.getUserId().getId()).isEqualTo(TEST_INTEGER);
		assertThat(createReserva.getIdTipoHabitacion().getId()).isEqualTo(TEST_INTEGER);
		assertThat(createReserva.getFechaInicio()).isEqualTo(TEST_DATE);
		assertThat(createReserva.getFechaFinal()).isEqualTo(TEST_DATE);
		
		
	}
	  public void validateAllReservas(Long expected) {
		    Long before =
		        repository
		            .get(repository.getSpecificationBuilder().of(Reserva.class).all().build())
		            .count();
		    assertThat(before).isEqualTo(expected);
		  }

}
