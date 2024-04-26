package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.AvionAerolinea;

import java.util.List;

public interface IAvionAerolinea {

    AvionAerolinea save(AvionAerolinea avionAerolinea);
    AvionAerolinea update(AvionAerolinea avionAerolinea);
    AvionAerolinea findById(Integer id);
    List<AvionAerolinea> findAll();
    void delete(AvionAerolinea avionAerolinea);
}
