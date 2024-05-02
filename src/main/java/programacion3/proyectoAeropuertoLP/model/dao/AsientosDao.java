package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Asientos;

public interface AsientosDao extends JpaRepository<Asientos, Integer> {
}
