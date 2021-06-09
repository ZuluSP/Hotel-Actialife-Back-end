package com.ctag.domain.model.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.Test;

import com.ctag.domain.model.roles.RolesCustomId;

public class UsersRepositoryIntegrationTest {

	private static final int ID = 1;
	private static final String STRING_TEST = "Test";

	@Inject
	private User underTest = new User();;

	@Inject
	private UserRepository repo;

	@Test
	public void findReservaByIdTest() {

		underTest = new User(new UserId(ID));

		repo.add(underTest);

		User us = repo.findUserById(new UserId(ID));

		assertThat(us.getId()).isEqualTo(underTest.getId());

	}

	@Test
	public void findUsersByRole() {

		underTest.setRoleId(new RolesCustomId(ID));

		repo.add(underTest);

		List<User> users = repo.findUsersByRole(new RolesCustomId(ID));

		assertThat(users.get(0).getRoleId()).isEqualTo(underTest.getRoleId());

	}

	@Test
	public void findUsersByName() {

		underTest.setName(STRING_TEST);

		repo.add(underTest);

		List<User> users = repo.findUsersByName(Optional.of(STRING_TEST));

		assertThat(users.get(0).getName()).isEqualTo(underTest.getName());

	}

	@Test
	public void getAllUsersTest() {

		List<User> users = new ArrayList<User>();

		users.add(underTest);

		repo.add(underTest);

		assertThat(repo.getAllUsers(Optional.of(ID), Optional.of(STRING_TEST))).isNotEmpty()
				.containsExactlyElementsOf(users).contains(underTest);
	}
}
