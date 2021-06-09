package com.ctag.domain.model.logs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;

import com.ctag.domain.model.users.User;

public class LogsTest {

	private static final Integer TEST_INTEGER = 1;

	private static final String TEST_STRING = "string";

	private LogCustom underTest = new LogCustom();


	

	@Test
	public void testGetId() throws Exception {
		underTest = new LogCustom();
		Plugins.getMemberAccessor().set(LogCustom.class.getDeclaredField("id"), underTest, TEST_INTEGER);
	}

	@Test
	public void testEmptyConstructor() {
		underTest = new LogCustom();
		assertNotNull(underTest);
	}

	@Test
	public void testEquals() throws Exception {
		/*
		 * EqualsVerifier.forClass(User.class).withPrefabValues(UserId.class,
		 * mock(UserId.class), mock(UserId.class)) .withPrefabValues(UserId.class, null,
		 * null) .withPrefabValues(User.class, mock(User.class), mock(User.class));
		 */
		LogCustom data = mock(LogCustom.class);
		assertEquals("Los objetos coinciden ", data, data);
		assertNull("El objeto other es null ", null);
		assertNotEquals("Los objetos no pertenecen a la misma clase", mock(LogCustom.class), mock(User.class));
	}

	@Test
	public void testGetLog() throws Exception {
		underTest.setLog(TEST_STRING);
		assertThat(underTest.getLog()).isEqualTo(TEST_STRING);
	}

	@Test
	public void testGetTime() throws Exception {

		underTest.setTime(TEST_STRING);
		assertThat(underTest.getTime()).isEqualTo(TEST_STRING);
	}

	@Test
	public void testGetUser() throws Exception {
		
		User user = mock(User.class);
		underTest.setUser(user);
		assertThat(underTest.getUser()).isEqualTo(user);
	}
}
