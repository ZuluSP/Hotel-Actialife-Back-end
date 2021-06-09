package com.ctag.domain.model.users;

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
public class UserFactoryIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final String TEST_STRING = "test";
	private static final Long INITIAL_EXPECTED_CONTROL_RESULTS = 8L;
	private static final Long EXPECTED_CONTROL_RESULTS = 9L;

	@Inject
	private UsersFactory factory;
	@Inject
	private UserRepository repository;

	@Test
	public void createHabitacionTipo() throws Exception {

		validateAllUsers(INITIAL_EXPECTED_CONTROL_RESULTS);

		User createUser = factory.createUser(TEST_STRING, TEST_STRING, TEST_STRING, TEST_STRING, TEST_STRING,
				TEST_STRING, TEST_INTEGER);

		validateAllUsers(EXPECTED_CONTROL_RESULTS);

		assertThat(createUser.getName()).isEqualTo(TEST_STRING);
		assertThat(createUser.getSurname()).isEqualTo(TEST_STRING);
		assertThat(createUser.getEmail()).isEqualTo(TEST_STRING);
		assertThat(createUser.getAddress()).isEqualTo(TEST_STRING);
		assertThat(createUser.getPassword()).isEqualTo(TEST_STRING);
		assertThat(createUser.getTelf()).isEqualTo(TEST_STRING);
		assertThat(createUser.getRoleId()).isEqualTo(TEST_INTEGER);
	}

	public void validateAllUsers(Long expected) {
		Long before = repository.get(repository.getSpecificationBuilder().of(User.class).all().build()).count();
		assertThat(before).isEqualTo(expected);
	}

}
