package com.ctag.domain.model.logs;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

import com.ctag.domain.model.users.UserId;

public class LogsRepositoryImpl extends BaseJpaRepository<LogCustom, LogsCustomId> implements LogsRepository {

  @Override
  public List<LogCustom> findLogsByUser(UserId id) {
    CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<LogCustom> q = cb.createQuery(LogCustom.class);
    Root<LogCustom> logs = q.from(LogCustom.class);

    List<LogCustom> user_logs = null;

    q.select(logs).distinct(true);

    if (id != null) {

      q.where(cb.equal(logs.get(LogCustom_.userId), id));
      user_logs = this.getEntityManager().createQuery(q).getResultList();
    }

    return user_logs;
  }

  @Override
  public List<LogCustom> getAllLogs() {
    CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<LogCustom> q = cb.createQuery(LogCustom.class);
    Root<LogCustom> logs = q.from(LogCustom.class);

    q.select(logs).distinct(true);

    return this.getEntityManager().createQuery(q).getResultList();
  }
}
