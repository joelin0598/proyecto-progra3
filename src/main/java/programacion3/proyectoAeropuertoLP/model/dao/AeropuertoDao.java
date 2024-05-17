
package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;

public interface AeropuertoDao extends JpaRepository<Aeropuerto, Integer> {
    Aeropuerto findByNombre(String nombre);
}
