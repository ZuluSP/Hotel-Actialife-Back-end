package com.ctag.tasks.habitaciontipo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.seedstack.jpa.JpaUnit;
import org.seedstack.scheduler.SchedulingContext;
import org.seedstack.scheduler.Task;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;
import com.ctag.domain.model.habitaciontipo.HabitacionTipoRepository;
import com.ctag.domain.services.HabitacionTipoService;

@Transactional
@JpaUnit
public class HabitacionTipoRaisePrice implements Task {

	private final HabitacionTipoRepository repo;
	private final HabitacionTipoService service;
	// private Logger logger;

	@Inject
	public HabitacionTipoRaisePrice(HabitacionTipoRepository repo, HabitacionTipoService service) {
		this.repo = repo;
		this.service = service;
	}

	@Override
	public void execute(SchedulingContext sc) throws Exception {

		// logger.info("execute");

		raisePrice();
	}

	public void raisePrice() {
		List<HabitacionTipo> rooms = repo.getAllRooms();

		for (HabitacionTipo room : rooms) {
			float price = room.getPrecio();
			if (room.getPrecio() >= 100) {
				service.lowerPrice(room);
			} else {
				room.setPrecio(price + 10);
			}
			// logger.info("Precio habitacion: " + room.getPrecio() + " Fecha:" +
			// Instant.now());
		}
	}
}
