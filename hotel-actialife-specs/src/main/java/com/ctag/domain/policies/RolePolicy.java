package com.ctag.domain.policies;

import org.seedstack.business.domain.DomainPolicy;


@DomainPolicy
public interface RolePolicy {

//	void changeName(Integer id);
	String changeName(String roleName);
}
