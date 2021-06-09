package com.ctag.rest.roles;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.roles.RoleCustom;
import com.ctag.domain.model.roles.RoleRepository;
import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.hotel.rest.api.RoleApiService;
import com.ctag.hotel.rest.model.RoleDto;
import com.ctag.hotel.rest.model.RoleUpdateDto;
import com.ctag.hotel.rest.model.RolecreateDto;
import com.ctag.model.dto.roles.InternalRoleCreateDto;

@JpaUnit
@Transactional
public class RolesApiServiceImpl implements RoleApiService {

  private final RoleRepository roleRepo;
  private final FluentAssembler assembler;

  @Inject
  public RolesApiServiceImpl(FluentAssembler assembler, RoleRepository roleRepo) {
    this.roleRepo = roleRepo;
    this.assembler = assembler;
  }

  @Override
  public Response createRole(RolecreateDto body, SecurityContext securityContext, UriInfo uriInfo) {
    RoleCustom role = assembler
    		.merge(new InternalRoleCreateDto(body))
    		.into(RoleCustom.class)
    		.fromFactory();

    
    
    
    RoleDto newRole = assembler.assemble(role).to(RoleDto.class);

    return Response.ok(newRole).build();
  }

  @Override
  public Response deleteRole(Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    roleRepo
        .get(new RolesCustomId(id))
        .orElseThrow(() -> new NotFoundException("Cannot delete an unexisting RoleCustom"));

    roleRepo.remove(new RolesCustomId(id));

    return Response.ok().build();
  }

  @Override
  public Response getRoles(
      Integer id, String name, SecurityContext securityContext, UriInfo uriInfo) {
    List<RoleCustom> roles = roleRepo.getAllRoles();
    List<RoleDto> rolesDto = assembler.assemble(roles).toListOf(RoleDto.class);

    return Response.ok(rolesDto).build();
  }

  @Override
  public Response updateRole(
      RoleUpdateDto body, Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    RoleCustom role = null;

    try {
      role =
          roleRepo
              .get(new RolesCustomId(id))
              .orElseThrow(() -> new NotFoundException("Cannot update an unexisting RoleCustom"));
    } catch (Exception e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped to the correct
      // response
      Response.noContent().build();
    }

    assembler.merge(body).into(role);

    RoleDto newDto = assembler.assemble(role).to(RoleDto.class);

    return Response.ok(newDto).build();
  }
}
