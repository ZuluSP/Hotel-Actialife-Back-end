package com.ctag.domain.model.roles;

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
public class RolesFactoryIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final String TEST_STRING = "test";
	private static final Long INITIAL_EXPECTED_CONTROL_RESULTS = 8L;
	private static final Long EXPECTED_CONTROL_RESULTS = 9L;

	@Inject
	private RolesFactory factory;
	@Inject
	private RoleRepository repository;

	@Test
	public void createHabitacionTipo() throws Exception {

		validateAllRoles(INITIAL_EXPECTED_CONTROL_RESULTS);

		RoleCustom createRole = factory.createRole(TEST_STRING);

		validateAllRoles(EXPECTED_CONTROL_RESULTS);

		assertThat(createRole.getNombreRol()).isEqualTo(TEST_INTEGER);

	}

	public void validateAllRoles(Long expected) {
		Long before = repository.get(repository.getSpecificationBuilder().of(RoleCustom.class).all().build()).count();
		assertThat(before).isEqualTo(expected);
	}

}
