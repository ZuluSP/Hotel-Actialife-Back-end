package com.ctag.rest.users;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.seedstack.business.assembler.dsl.FluentAssembler;
import org.seedstack.jpa.JpaUnit;

import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.domain.model.users.User;
import com.ctag.domain.model.users.UserId;
import com.ctag.domain.model.users.UserRepository;
import com.ctag.hotel.rest.api.UserApiService;
import com.ctag.hotel.rest.model.UserDto;
import com.ctag.hotel.rest.model.UserUpdateDto;
import com.ctag.hotel.rest.model.UsercreateDto;
import com.ctag.model.dto.user.InternalUserCreateDto;
import com.ctag.paperless.utils.exceptions.jpa.persistance.CannotFindException;
import com.ctag.paperless.utils.rest.response.PaperlessResponse;
import com.ctag.paperless.utils.rest.response.PaperlessResponseException;

import javassist.NotFoundException;

@JpaUnit
@Transactional
public class UserApiServiceImpl implements UserApiService {

  private final UserRepository userRepo;
  private final FluentAssembler assembler;

  @Inject
  public UserApiServiceImpl(UserRepository userRepo, FluentAssembler assembler) {
    this.userRepo = userRepo;
    this.assembler = assembler;
  }

  @Override
  public Response createuser(UsercreateDto body, SecurityContext securityContext, UriInfo uriInfo) {
    User user = assembler
    		.merge(new InternalUserCreateDto(body))
    		.into(User.class)
    		.fromFactory();

    UserDto newDto = assembler.assemble(user).to(UserDto.class);

    return Response.ok(newDto).build();
  }

  @Override
  public Response deleteuser(Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    User user = null;
    try {
      user =
          userRepo.get(new UserId(id)).orElseThrow(() -> new NotFoundException("cannot find user"));
    } catch (NotFoundException e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped to the correct
      // response
      Response.notModified().build();
    }

    userRepo.remove(user);

    return Response.ok().build();
  }

  @Override
  public Response findUsers(
      Integer id, String name, SecurityContext securityContext, UriInfo uriInfo) {

    List<User> users = userRepo.getAllUsers(Optional.ofNullable(id), Optional.ofNullable(name));

    List<UserDto> newDto = assembler.assemble(users).toListOf(UserDto.class);

    return Response.ok(newDto).build();
  }

  @Override
  public Response getUserById(Integer id, SecurityContext securityContext, UriInfo uriInfo) {

    try {
      return PaperlessResponse.with(
          assembler.assemble(userRepo.getOrException(new UserId(id))).to(UserDto.class));
    } catch (CannotFindException e) {
      throw new PaperlessResponseException(e, Status.NOT_FOUND);
    }
  }

  /*
   * User user = null; try { user = userRepo.findUserById(new UserId(id));
   *
   * } catch (Exception e) { Response.noContent().build(); } UserDto newUser =
   * assembler.assemble(user).to(UserDto.class);
   *
   * return Response.ok(newUser).build();
   */

  @Override
  public Response getUserByRole(Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    List<User> users = null;
    try {
      users = userRepo.findUsersByRole(new RolesCustomId(id));
    } catch (Exception e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped to the correct
      // response
      Response.noContent().build();
    }
    List<UserDto> newDto = assembler.assemble(users).toListOf(UserDto.class);

    return Response.ok(newDto).build();
  }

  @Override
  public Response updateuser(
      UserUpdateDto body, Integer id, SecurityContext securityContext, UriInfo uriInfo) {
    User user = null;
    try {
      user =
          userRepo.get(new UserId(id)).orElseThrow(() -> new NotFoundException("cannot find user"));
    } catch (NotFoundException e) {
      // FIXME: This is not being returned, also Exceptions are automatically mapped to the correct
      // response
      Response.notModified().build();
    }

    assembler.merge(body).into(user);

    UserDto newDto = assembler.assemble(user).to(UserDto.class);

    return Response.ok(newDto).build();
  }
}
