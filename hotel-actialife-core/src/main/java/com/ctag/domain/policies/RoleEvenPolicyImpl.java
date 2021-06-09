package com.ctag.domain.policies;

import javax.inject.Named;

@Named("RoleEven")
public class RoleEvenPolicyImpl implements RolePolicy {

//	private final RoleRepository repo;

//	@Inject
//	public RoleEvenPolicyImpl(RoleRepository repo) {
//		this.repo = repo;
//	}

	@Override
	public String changeName(String roleName) {

//		Optional<RoleCustom> role = repo.findRoleById(new RolesCustomId(id));
//		System.err.println("RoleEven executed " + role);
//
//		role.ifPresent(r -> r.setNombreRol(r.getNombreRol() + "+"));
		return roleName + "+";
	}

}
