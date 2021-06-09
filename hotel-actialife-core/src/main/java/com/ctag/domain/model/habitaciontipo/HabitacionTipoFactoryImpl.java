package com.ctag.domain.model.habitaciontipo;

import javax.inject.Inject;

import org.seedstack.business.domain.BaseFactory;


 
public class HabitacionTipoFactoryImpl extends BaseFactory<HabitacionTipo> implements HabitacionTipoFactory {
 
	
	private final HabitacionTipoRepository repo;
	
	@Inject
	public HabitacionTipoFactoryImpl(HabitacionTipoRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public HabitacionTipo createHabitacionTipo(String tipoHabitacion, String descripcion, float precio, float m2,
			Integer numeroHabitaciones) {
 
		HabitacionTipo habitaciontipo = this.create();
 
		habitaciontipo.setDescripcion(descripcion);
		habitaciontipo.setM2(m2);
		habitaciontipo.setNumeroHabitaciones(numeroHabitaciones);
		habitaciontipo.setPrecio(precio);
		habitaciontipo.setTipoHabitacion(tipoHabitacion);
		
		repo.add(habitaciontipo);
	
		return habitaciontipo;
	}
 
}

