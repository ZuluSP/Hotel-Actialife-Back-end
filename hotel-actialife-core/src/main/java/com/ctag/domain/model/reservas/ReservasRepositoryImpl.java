package com.ctag.domain.model.reservas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.seedstack.jpa.BaseJpaRepository;

import com.ctag.domain.model.habitaciontipo.HabitacionTipoId;
import com.ctag.domain.model.users.UserId;

public class ReservasRepositoryImpl extends BaseJpaRepository<Reserva, ReservasId> implements ReservasRepository {

	@Override
	public Reserva findReservaById(ReservasId id) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Reserva> q = cb.createQuery(Reserva.class);
		Root<Reserva> reserva = q.from(Reserva.class);

		Predicate r1 = null;

		q.select(reserva).distinct(true);

		if (id != null) {
			r1 = cb.equal(reserva.get(Reserva_.id), id);
		}

		q.where(r1);

		return this.getEntityManager().createQuery(q).getSingleResult();
	}

	@Override
	public List<Reserva> findReservasByUserId(UserId id) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Reserva> q = cb.createQuery(Reserva.class);
		Root<Reserva> reserva = q.from(Reserva.class);

		q.select(reserva).distinct(true);
		Predicate r1 = null;
		if (id != null) {
			r1 = cb.equal(reserva.get(Reserva_.userId), id);
		}
		q.where(r1);

		return this.getEntityManager().createQuery(q).getResultList();
	}

	@Override
	public List<Reserva> findReservasByHabitacionTipo(HabitacionTipoId id) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Reserva> q = cb.createQuery(Reserva.class);
		Root<Reserva> reserva = q.from(Reserva.class);

		q.select(reserva).distinct(true);

		Predicate r1 = null;

		if (id != null) {
			r1 = cb.equal(reserva.get(Reserva_.idTipoHabitacion), id);
		}
		q.where(r1);

		return this.getEntityManager().createQuery(q).getResultList();
	}

	@Override
	public List<Reserva> findReservasByDate(LocalDate fechaInicio, LocalDate fechaFin) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Reserva> q = cb.createQuery(Reserva.class);
		Root<Reserva> reserva = q.from(Reserva.class);

		q.select(reserva).distinct(true);

		List<Predicate> r1 = new ArrayList<Predicate>();

		if (fechaInicio != null && fechaFin != null) {

			r1.add(cb.between(reserva.get(Reserva_.fechaInicio), fechaInicio, fechaFin));

			r1.add(cb.between(reserva.get(Reserva_.fechaFinal), fechaInicio, fechaFin));

			/*
			 * "select * from reservas where " +
			 * "(fecha_inicio BETWEEN ? and ? or fecha_fin BETWEEN ? and ?"
			 */
		}
		q.where(r1.toArray(new Predicate[] {}));

		return this.getEntityManager().createQuery(q).getResultList();
	}

	@Override
	public List<Reserva> getAllReservas() {
		final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<Reserva> q = cb.createQuery(Reserva.class);
		final Root<Reserva> reserva = q.from(Reserva.class);
		List<Reserva> reservas = null;
		q.select(reserva).distinct(true);
		reservas = this.getEntityManager().createQuery(q).getResultList();
		return reservas;
	}

}