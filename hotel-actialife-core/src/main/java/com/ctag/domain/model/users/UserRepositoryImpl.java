package com.ctag.domain.model.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

import com.ctag.domain.model.roles.RolesCustomId;

public class UserRepositoryImpl extends BaseJpaRepository<User, UserId> implements UserRepository {

	@Override
	public User findUserById(UserId id) {
		final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> q = cb.createQuery(User.class);
		final Root<User> users = q.from(User.class);
		Predicate u1 = null;
		User user = null;

		q.select(users).distinct(true);
		if (id != null) {
			u1 = cb.equal(users.get(User_.id), id);
			q.select(users).where(u1);
			user = this.getEntityManager().createQuery(q).getSingleResult();
		}
		return user;
	}

	@Override
	public List<User> findUsersByRole(RolesCustomId id) {
		final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> q = cb.createQuery(User.class);
		final Root<User> users = q.from(User.class);
		Predicate u1 = null;
		List<User> user = null;

		q.select(users).distinct(true);
		if (id != null) {
			u1 = cb.equal(users.get(User_.roleId), id);
			q.select(users).where(u1);
			user = this.getEntityManager().createQuery(q).getResultList();
		}
		return user;
	}

	@Override
	public List<User> findUsersByName(Optional<String> name) {
		final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> q = cb.createQuery(User.class);
		final Root<User> users = q.from(User.class);
		// Predicate u1 = null;
		List<User> user = null;
		q.select(users).distinct(true);

		name.ifPresent(nam -> {
			Predicate u1 = cb.equal(users.get(User_.name), nam);
			q.select(users).where(u1);

		});
		user = this.getEntityManager().createQuery(q).getResultList();

		return user;
	}

	@Override
	public List<User> getAllUsers(Optional<Integer> id, Optional<String> name) {

		final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> q = cb.createQuery(User.class);
		final Root<User> users = q.from(User.class);
		List<Predicate> u1 = new ArrayList<Predicate>();
		List<User> user = null;
		q.select(users).distinct(true);

		name.ifPresent(nam -> {
			u1.add(cb.equal(users.get(User_.name), nam));

		});
		id.ifPresent(i -> {
			u1.add(cb.equal(users.get(User_.id), i));

		});
		q.select(users).where(u1.toArray(new Predicate[] {}));
		user = this.getEntityManager().createQuery(q).getResultList();

		return user;
	}
}