package com.ctag.domain.model.roles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

public class RolesRepositoryIntegrationTest {

	private static final String TEST_STRING = "Test";

	@Inject
	private RoleCustom underTest = new RoleCustom();

	@Inject
	private RoleRepository repo;

	@Test
	public void getAllRolesTest() {

		List<RoleCustom> roles = new ArrayList<RoleCustom>();

		roles.add(underTest);

		repo.add(underTest);

		assertThat(repo.getAllRoles()).isNotEmpty().containsExactlyElementsOf(roles).contains(underTest);
	}

	@Test
	public void findRoleByNameTest() {

		underTest.setNombreRol(TEST_STRING);

		RoleCustom newRole = repo.findRoleByName(TEST_STRING);

		assertThat(newRole).isEqualTo(underTest); // AÑADIR .getNombreRol???

	}

}
