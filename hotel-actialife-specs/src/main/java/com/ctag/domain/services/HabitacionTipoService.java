package com.ctag.domain.services;

import org.seedstack.business.Service;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;

@Service
public interface HabitacionTipoService {
	void lowerPrice(HabitacionTipo room);
}
