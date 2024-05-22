package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;

import java.util.List;

public interface IAvion {
    Avion save(Avion avion);
    Avion update(Avion avion);
    Avion findById(Integer id);
    List<Avion> findAll();
    Avion findByModelo(String modelo);
    void delete(Avion avion);
    List<Avion> findByAerolineaId(Aerolinea aerolinea);
}
