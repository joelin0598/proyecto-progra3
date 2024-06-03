package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;

import java.util.List;

public interface DestinoDao extends JpaRepository<Destino, Integer> {
    List<Destino> findByAerolineaId(Aerolinea aerolinea);
    //List<Aeropuerto> findAeropuertosByAerolinea(Aerolinea aerolinea);
}
