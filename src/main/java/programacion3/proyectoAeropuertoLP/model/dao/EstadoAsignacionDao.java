package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.EstadoAsignacion;

public interface EstadoAsignacionDao extends JpaRepository<EstadoAsignacion, Integer> {
}
