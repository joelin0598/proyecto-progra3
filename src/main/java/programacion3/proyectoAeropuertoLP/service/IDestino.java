package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Destino;

import java.util.List;

public interface IDestino {
    Destino save(Destino destino);
    Destino findById(Integer id);

    void delete(Destino destino);
    List<Destino> findAll();
}
