package com.ctag.domain.model.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;
 
public class UserTest {
 
	private static final Integer TEST_INTEGER = 1;
 
	private static final String TEST_STRING = "test";
 
	private User underTest = new User();
/*
	@Before
	public void setUp() throws Exception {
		underTest = new User();
	}*/
 
	@Test
	public void testEquals() throws Exception {
		/*
		 * EqualsVerifier.forClass(User.class).withPrefabValues(UserId.class,
		 * mock(UserId.class), mock(UserId.class)) .withPrefabValues(UserId.class, null,
		 * null) .withPrefabValues(User.class, mock(User.class), mock(User.class));
		 */
 
		User data = mock(User.class);
		assertEquals("Los objetos coinciden ", data, data);
		assertNull("El objeto other es null ", null);
		assertNotEquals("Los objetos no pertenecen a la misma clase", mock(User.class), mock(UserId.class));
	}
 
	@Test
	public void testEmptyConstructor() {
		underTest = new User();
		assertNotNull(underTest);
	}
 
	@Test
	public void testToString() throws Exception {
		underTest.setName(TEST_STRING);
		underTest.setSurname(TEST_STRING);
		underTest.setEmail(TEST_STRING);
		underTest.setPassword(TEST_STRING);
		underTest.setTelf(TEST_STRING);
		underTest.setAddress(TEST_STRING);
		assertThat(underTest.toString()).contains(TEST_INTEGER.toString());
	}
 
	@Test
	public void getName() throws Exception {
		underTest.setName(TEST_STRING);
		assertThat(underTest.getName()).isEqualTo(TEST_STRING);;
	}
 
	@Test
	public void getSurname() throws Exception {
		underTest.setSurname(TEST_STRING);
		assertThat(underTest.getSurname()).isEqualTo(TEST_STRING);;
	}
 
	@Test
	public void getAddress() throws Exception {
		underTest.setAddress(TEST_STRING);
		assertThat(underTest.getAddress()).isEqualTo(TEST_STRING);;
	}
 
	@Test
	public void getEmail() throws Exception {
		underTest.setEmail(TEST_STRING);
		assertThat(underTest.getEmail()).isEqualTo(TEST_STRING);
	}
 
	@Test
	public void getTelf() throws Exception {
		underTest.setTelf(TEST_STRING);
		assertThat(underTest.getTelf()).isEqualTo(TEST_STRING);;
	}
 
	@Test
	public void getId() throws Exception {
		try {
			Plugins.getMemberAccessor().set(User.class.getDeclaredField("id"), underTest, TEST_INTEGER);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
 
}