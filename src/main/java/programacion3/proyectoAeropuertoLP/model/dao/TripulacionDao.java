package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Tripulacion;

public interface TripulacionDao extends JpaRepository<Tripulacion, Integer> {
}
