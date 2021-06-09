package com.ctag.domain.model.users;

import javax.inject.Inject;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.domain.model.roles.RolesCustomId;
 
public class UsersFactoryImpl extends BaseFactory<User> implements UsersFactory {
 
	private final UserRepository repo;
 
	@Inject
	public UsersFactoryImpl(UserRepository repo) {
		this.repo = repo;
	}
 
	@Override
	public User createUser(String name, String surname, String email, String telf, String address,
			String password, Integer idRole) {
 
		User user = this.create();
 
		// Asignacion de role a un user
		user.setRoleId(new RolesCustomId(idRole));
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setTelf(telf);
		user.setAddress(address);
		user.setPassword(password);
 
		repo.add(user);
 
		return user;
	}
}