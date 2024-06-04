package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinoDao extends JpaRepository<Destino, Integer> {
    List<Destino> findByAerolineaId(Aerolinea aerolinea);
    List<Destino> findByAeropuertoId(Aeropuerto aeropuerto);

    @Query("SELECT d FROM Destino d WHERE d.aerolineaId.id = :aerolineaId")
    List<Destino> findDestinosByAerolineaId(@Param("aerolineaId") Integer aerolineaId);
}
