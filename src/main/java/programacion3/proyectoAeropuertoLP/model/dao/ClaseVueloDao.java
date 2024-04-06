package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.ClaseVuelo;

public interface ClaseVueloDao extends JpaRepository<ClaseVuelo, Integer> {
}
