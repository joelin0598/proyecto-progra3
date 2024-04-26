package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Pasajero;

import java.util.List;

public interface IPasajero {
    Pasajero save(Pasajero pasajero);
    Pasajero update(Pasajero pasajero);
    Pasajero findById(Integer id);
    List<Pasajero> findAll();
    void delete(Pasajero pasajero);
    boolean existsByPasaporte(String pasaporte);
    //boolean isValidPassword(String password);
}
