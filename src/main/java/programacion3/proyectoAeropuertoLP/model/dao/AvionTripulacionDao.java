package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.AvionTripulacion;

public interface AvionTripulacionDao extends JpaRepository<AvionTripulacion, Integer> {
}
