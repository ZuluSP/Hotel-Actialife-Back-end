package com.ctag.domain.model.roles;

import java.util.List;
import java.util.Optional;

import org.seedstack.business.domain.Repository;
 
 
public interface RoleRepository extends Repository <RoleCustom, RolesCustomId>{
 
  RoleCustom findRoleByName(String name);
 
  default Optional<RoleCustom> findRoleById(RolesCustomId id) {
	  return this.get(id);
  }
  
  List<RoleCustom> getAllRoles();
}