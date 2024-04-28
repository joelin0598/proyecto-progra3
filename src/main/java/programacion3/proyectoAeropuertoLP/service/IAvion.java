package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.dto.AvionDto;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;

import java.util.List;

public interface IAvion {

    Avion save(Avion avion);
    Avion update(Avion avion);
    Avion findById(Integer id);
    List<Avion> findAll();

    List<Avion> findActiveByAerolineaId(Integer aerolineaId);
    void delete(Avion avion);
    List<Avion> findActiveByAerolineaIdAndEstadoTrue(Integer aerolineaId);

    List<AvionDto> obtenerListaAviones(Integer estado);

}

