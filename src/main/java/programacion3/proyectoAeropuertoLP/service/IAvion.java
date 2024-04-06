package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Avion;

import java.util.List;

public interface IAvion {

    Avion save(Avion avion);
    Avion findById(Integer id);
    void delete(Avion avion);
    List<Avion> findAll();
}
