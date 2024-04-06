package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.TripulacionVuelo;

import java.util.List;

public interface ITripulacionVuelo {
    TripulacionVuelo save(TripulacionVuelo tripulacionVuelo);
    TripulacionVuelo update(TripulacionVuelo tripulacionVuelo);
    TripulacionVuelo findById(Integer id);
    List<TripulacionVuelo> findAll();
    void delete(TripulacionVuelo tripulacionVuelo);
}
