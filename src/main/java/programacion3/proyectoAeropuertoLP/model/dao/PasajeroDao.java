package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Pasajero;

public interface PasajeroDao extends JpaRepository<Pasajero, Integer> {
    boolean existsByPasaporte(String pasaporte);
    //boolean isValidPassword(String password);
}
