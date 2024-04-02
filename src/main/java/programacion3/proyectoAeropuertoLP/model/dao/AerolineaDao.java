package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;

public interface AerolineaDao extends JpaRepository<Aerolinea, Integer> {
    
}
