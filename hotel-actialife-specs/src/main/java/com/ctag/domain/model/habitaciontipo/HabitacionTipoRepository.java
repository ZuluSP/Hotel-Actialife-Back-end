package com.ctag.domain.model.habitaciontipo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ctag.paperless.utils.domain.PaperlessRepository;
 

public interface HabitacionTipoRepository extends PaperlessRepository<HabitacionTipo, HabitacionTipoId> {
 
  default Optional<HabitacionTipo> findHabitacionTipoById(HabitacionTipoId id) {
    return this.get(id);
  };
 
  default List<HabitacionTipo> findHabitacionTipoByName(String habitacionTipo) {
    return this.get(
            getSpecificationBuilder()
                .ofAggregate(HabitacionTipo.class)
                .property(HabitacionTipo_.TIPO_HABITACION)
                .equalTo(habitacionTipo)
                .build())
        .collect(Collectors.toList());
  };
 
  List<HabitacionTipo> getAllRooms();
}
