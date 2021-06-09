package com.ctag.domain.model.roles;

import org.seedstack.business.domain.Factory;
 
public interface RolesFactory extends Factory<RoleCustom>{
	
	RoleCustom createRole(String nombre);
 
}