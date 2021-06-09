package com.ctag.domain.model.roles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Set;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;

import com.ctag.domain.model.users.User;

class RolesTest {

	private static final Integer TEST_INTEGER = 1;

	private static final String TEST_STRING = "test";

	private RoleCustom underTest = new RoleCustom();

	@Test
	public void testEmptyConstructor() {
		underTest = new RoleCustom();
		assertNotNull(underTest);
	}

	@Test
	public void testGetNombreRol() throws Exception {
		underTest.setNombreRol(TEST_STRING);
		assertThat(underTest.getNombreRol()).isEqualTo(TEST_STRING);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testGetUsers() throws Exception {
		Set<User> mockedSet = mock(Set.class);
		when(mockedSet.size()).thenReturn(TEST_INTEGER);
		testSetUsers(mockedSet);
		assertThat(underTest.getUsers().size()).isEqualTo(TEST_INTEGER);
	}

	@Test
	public void testGetId() throws Exception {
		underTest = new RoleCustom();
		Plugins.getMemberAccessor().set(RoleCustom.class.getDeclaredField("id"), underTest, TEST_INTEGER);
		assertThat(underTest.getId().getId()).isEqualTo(TEST_INTEGER);
	}

	@Test
	public void testToString() throws Exception {
		underTest.setNombreRol(TEST_STRING);
		assertThat(underTest.toString()).contains(TEST_STRING);
	}

	@Test
	public void testEquals() throws Exception {
		/*
		 * EqualsVerifier.forClass(User.class).withPrefabValues(UserId.class,
		 * mock(UserId.class), mock(UserId.class)) .withPrefabValues(UserId.class, null,
		 * null) .withPrefabValues(User.class, mock(User.class), mock(User.class));
		 */

		RoleCustom data = mock(RoleCustom.class);
		assertEquals("Los objetos coinciden ", data, data);
		assertNull("El objeto other es null ", null);
		assertNotEquals("Los objetos no pertenecen a la misma clase", mock(RoleCustom.class), mock(User.class));
	}

	private void testSetUsers(Set<User> users) throws Exception {
		Field user = RoleCustom.class.getDeclaredField("users");
		user.setAccessible(true);
		user.set(underTest, users);
		user.setAccessible(false);
	}
}