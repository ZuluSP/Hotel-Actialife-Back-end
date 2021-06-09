package com.ctag.domain.model.users;

import java.util.List;
import java.util.Optional;

import com.ctag.domain.model.roles.RolesCustomId;
import com.ctag.paperless.utils.domain.PaperlessRepository;

public interface UserRepository extends PaperlessRepository<User, UserId> {

	User findUserById(UserId id);

	List<User> findUsersByRole(RolesCustomId id);

	List<User> getAllUsers(Optional<Integer> id, Optional<String> name);

	List<User> findUsersByName(Optional<String> name);

}