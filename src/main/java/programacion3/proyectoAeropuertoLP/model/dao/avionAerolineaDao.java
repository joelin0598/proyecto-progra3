package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.avionAerolinea;

public interface avionAerolineaDao extends JpaRepository<avionAerolinea, Integer> {
}
