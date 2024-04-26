package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.AvionTripulacion;

import java.util.List;

public interface IAvionTripulacion {
    AvionTripulacion save(AvionTripulacion avionTripulacion);
    AvionTripulacion update(AvionTripulacion avionTripulacion);
    AvionTripulacion findById(Integer id);
    List<AvionTripulacion> findAll();
    void delete(AvionTripulacion avionTripulacion);
}
