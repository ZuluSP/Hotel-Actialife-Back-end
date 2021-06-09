package com.ctag.domain.policies;

import javax.inject.Named;

@Named("RoleOdd")
public class RoleOddPolicyImpl implements RolePolicy {

//	private final RoleRepository repo;

//	@Inject
//	public RoleOddPolicyImpl(RoleRepository repo) {
//		this.repo = repo;
//	}

	@Override
	public String changeName(String roleName) {

//		Optional<RoleCustom> role = repo.findRoleById(new RolesCustomId(id));
//		System.err.println("RoleOdd executed");
//		role.get().setNombreRol(role.get().getNombreRol() + "-");
		return roleName + "-";

	}
}
