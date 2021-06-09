package com.ctag.domain.model.habitaciontipo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ctag.paperless.utils.jpa.PaperlessJpaRepository;

public class HabitacionTipoRespositoryImpl
    extends PaperlessJpaRepository<HabitacionTipo, HabitacionTipoId>
    implements HabitacionTipoRepository {

  @Override
  public List<HabitacionTipo> findHabitacionTipoByName(String habitacionTipo) {
    CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<HabitacionTipo> q = cb.createQuery(HabitacionTipo.class);
    Root<HabitacionTipo> habitacionesTipo = q.from(HabitacionTipo.class);

    List<HabitacionTipo> tipoHabitacion = null;

    q.select(habitacionesTipo).distinct(true);

    if (habitacionTipo != null) {

      q.where(cb.equal(habitacionesTipo.get(HabitacionTipo_.tipoHabitacion), habitacionTipo));

      tipoHabitacion = this.getEntityManager().createQuery(q).getResultList();
    }

    return tipoHabitacion;
  }

  @Override
  public List<HabitacionTipo> getAllRooms() {
    final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    final CriteriaQuery<HabitacionTipo> q = cb.createQuery(HabitacionTipo.class);
    final Root<HabitacionTipo> room = q.from(HabitacionTipo.class);
    List<HabitacionTipo> rooms = null;
    q.select(room).distinct(true);
    rooms = this.getEntityManager().createQuery(q).getResultList();
    return rooms;
  }
}
