package com.ctag.domain.model.habitaciontipo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ctag.domain.model.users.UserId;
 
public class HabitacionTipoIdTest {
 
	private static final Integer TEST_INTEGER = 1;
 
	private HabitacionTipoId underTest = new HabitacionTipoId(TEST_INTEGER);
 
	@Test
	public void testGetId() throws Exception {
		Assertions.assertThat(underTest.getId()).isNotNull().isEqualTo(TEST_INTEGER);
	}
 
	@Test
	public void testEmptyConstructor() throws Exception {
		underTest = new HabitacionTipoId();
		assertNotNull(underTest);
	}
 
	@Test
	public void testEquals() throws Exception {
 
		HabitacionTipoId data = mock(HabitacionTipoId.class);
		assertEquals("Los objetos coinciden ", data, data);
		assertNull("El objeto other es null ", null);
		assertNotEquals("Los objetos no pertenecen a la misma clase", mock(HabitacionTipoId.class), mock(UserId.class));
	}
 
}
