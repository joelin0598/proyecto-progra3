package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.AvionAerolinea;

import java.util.List;

public interface IAvionAerolinea {

    AvionAerolinea save(AvionAerolinea avionAerolinea);
    AvionAerolinea findById(Integer id);
    void delete(AvionAerolinea avionAerolinea);
    List<AvionAerolinea> findAll();
}
