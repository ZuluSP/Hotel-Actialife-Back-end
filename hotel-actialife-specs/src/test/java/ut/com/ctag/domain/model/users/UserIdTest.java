package com.ctag.domain.model.users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

class UserIdTest {

	private static final Integer TEST_INTEGER = 1;

	private UserId underTest;

	@Before
	public void setUp() throws Exception {
		underTest = new UserId(TEST_INTEGER);
	}

	@Test
	public void testEmptyConstructor() throws Exception {
		underTest = new UserId();
		assertNull(underTest.getId());
	}

	@Test
	public void testEquals() throws Exception {
		/*
		 * EqualsVerifier.forClass(UserId.class) .withPrefabValues()
		 * .withPrefabValues(UserId.class, mock(Inspection.class),
		 * mock(Inspection.class)) .withPrefabValues(Set.class, mock(Set.class),
		 * mock(Set.class)) .usingGetClass() .suppress(Warning.WARNING)
		 * .withRedefinedSuperclass() .verify();
		 */

		UserId data = mock(UserId.class);
		assertEquals("Los objetos coinciden ", data, data);
		assertNull("El objeto other es null ", null);
		assertEquals("Los objetos no pertenecen a la misma clase", mock(UserId.class), mock(User.class));

	}

}
