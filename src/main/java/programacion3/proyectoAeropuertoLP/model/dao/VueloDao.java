package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Integer> {
    /*boolean validarAerolineaConAvionesActivos(Integer aerolineaId);*/
}
