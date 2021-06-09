package com.ctag.domain.model.roles;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

public class RoleRepositoryImpl extends BaseJpaRepository<RoleCustom, RolesCustomId>
    implements RoleRepository {

  /*
   * DONE WITH DEFAULT IN INTERFACE
   *
   * @Override public RoleCustom findRoleById(RolesCustomId id) { CriteriaBuilder cb =
   * this.getEntityManager().getCriteriaBuilder(); CriteriaQuery<RoleCustom> q =
   * cb.createQuery(RoleCustom.class); Root<RoleCustom> roles = q.from(RoleCustom.class);
   * Predicate r1 = null; RoleCustom rol = null;
   *
   * q.select(roles).distinct(true); if (id != null) { r1 =
   * cb.equal(roles.get(Roles_.ID), id); q.where(r1); rol =
   * this.getEntityManager().createQuery(q).getSingleResult(); } return rol; }
   */

  @Override
  public RoleCustom findRoleByName(String name) {
    CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<RoleCustom> q = cb.createQuery(RoleCustom.class);
    Root<RoleCustom> roles = q.from(RoleCustom.class);

    q.select(roles).distinct(true);
    Predicate r1 = null;
    RoleCustom rol = null;
    if (name != null) {
      r1 = cb.equal(roles.get(RoleCustom_.nombreRol), "%" + name + "%");
      q.where(r1);

      rol = this.getEntityManager().createQuery(q).getSingleResult();
    }

    return rol;
  }

  @Override
  public List<RoleCustom> getAllRoles() {
    final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    final CriteriaQuery<RoleCustom> q = cb.createQuery(RoleCustom.class);
    final Root<RoleCustom> role = q.from(RoleCustom.class);
    List<RoleCustom> roles = null;
    q.select(role).distinct(true);

    roles = this.getEntityManager().createQuery(q).getResultList();

    return roles;
  }
}
