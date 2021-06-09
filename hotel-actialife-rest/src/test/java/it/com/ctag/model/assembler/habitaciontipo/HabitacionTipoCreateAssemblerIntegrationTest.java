package com.ctag.model.assembler.habitaciontipo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoRepository;
import com.ctag.hotel.rest.model.HabitacionTipoCreateDto;
import com.ctag.model.dto.habitaciontipo.InternalHabitacionTipoCreateDto;

@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class HabitacionTipoCreateAssemblerIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final float TEST_FLOAT = 1;
	private static final String TEST_STRING = "test";

	@Inject
	private FluentAssembler fluent;
	@Inject
	private HabitacionTipoRepository repo;

	@Test
	public void testMergeAggregateIntoDto() {
		HabitacionTipo habitacionTipo = repo.get(new HabitacionTipoId(TEST_INTEGER)).get();
		assertThatThrownBy(() -> fluent.assemble(habitacionTipo).to(InternalHabitacionTipoCreateDto.class))
				.isInstanceOf(UnsupportedOperationException.class);
	}

	HabitacionTipo room = mock(HabitacionTipo.class);

	@Test
	public void testMergeDtoIntoAggregate() {
		HabitacionTipoCreateDto dto = new HabitacionTipoCreateDto();
		dto.setDescripcion(TEST_STRING);
		;
		dto.setM2(TEST_FLOAT);
		dto.setNumeroHabitaciones(TEST_INTEGER);
		dto.setPrecio(TEST_FLOAT);
		dto.setTipoHabitacion(TEST_STRING);

		InternalHabitacionTipoCreateDto expected = new InternalHabitacionTipoCreateDto(dto);

		HabitacionTipo habitacionTipo = fluent.merge(expected).into(HabitacionTipo.class).fromFactory();

		assertThat(habitacionTipo.getDescripcion()).isEqualTo(dto.getDescripcion());
		assertThat(habitacionTipo.getM2()).isEqualTo(dto.getM2());
		assertThat(habitacionTipo.getNumeroHabitaciones()).isEqualTo(dto.getNumeroHabitaciones());
		assertThat(habitacionTipo.getPrecio()).isEqualTo(dto.getPrecio());
		assertThat(habitacionTipo.getTipo_habitacion()).isEqualTo(dto.getTipoHabitacion());

	}
}
