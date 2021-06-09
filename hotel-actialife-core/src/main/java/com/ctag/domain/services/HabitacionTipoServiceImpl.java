package com.ctag.domain.services;

import com.ctag.domain.model.habitaciontipo.HabitacionTipo;


public class HabitacionTipoServiceImpl implements HabitacionTipoService {


	@Override
	public void lowerPrice(HabitacionTipo room) {
		room.setPrecio(room.getPrecio() - 50);
	}

}
