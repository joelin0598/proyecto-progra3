package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;

public interface DestinoDao extends JpaRepository<Destino, Integer> {
}
