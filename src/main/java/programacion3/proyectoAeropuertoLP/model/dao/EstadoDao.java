package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Estado;

public interface EstadoDao extends JpaRepository<Estado, Integer> {
}
