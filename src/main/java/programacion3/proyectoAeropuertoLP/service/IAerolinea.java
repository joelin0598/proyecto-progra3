package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;


import java.util.List;

public interface IAerolinea {

    Aerolinea save(Aerolinea aerolinea);
    Aerolinea findById(Integer id);
    void delete(Aerolinea aerolinea);
    List<Aerolinea> findAll();
}
