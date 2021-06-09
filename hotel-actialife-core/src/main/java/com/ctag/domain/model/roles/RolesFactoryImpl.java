package com.ctag.domain.model.roles;

import javax.inject.Inject;
import javax.inject.Named;

import org.seedstack.business.domain.BaseFactory;

import com.ctag.domain.policies.RolePolicy;

public class RolesFactoryImpl extends BaseFactory<RoleCustom> implements RolesFactory {

	private final RoleRepository repo;

	private final RolePolicy roleEven;

	private final RolePolicy roleOdd;

	@Inject
	public RolesFactoryImpl(RoleRepository repo, @Named("RoleEven") RolePolicy roleEven,
			@Named("RoleOdd") RolePolicy roleOdd) {
		this.repo = repo;
		this.roleEven = roleEven;
		this.roleOdd = roleOdd;
	}

	@Override
	public RoleCustom createRole(String nombre) {

		int size = repo.getAllRoles().size() - 1;
		RoleCustom lastRole = repo.getAllRoles().get(size);
		
		RoleCustom roles = this.create();

		String changeName;
		System.err.println(roles);
		if (lastRole.getId().getId() % 2 == 0) {

			changeName = roleEven.changeName(roles.getNombreRol());
		} else {

			changeName = roleOdd.changeName(roles.getNombreRol());
		}

		roles.setNombreRol(changeName);

		// Esto se usa para agregarle el id y guardar en Base de Datos
		repo.add(roles);

		return roles;
	}
}