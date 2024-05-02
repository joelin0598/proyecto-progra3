package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Destino;

import java.util.List;

public interface IDestino {
    Destino save(Destino destino);
    Destino update(Destino destino);
    Destino findById(Integer id);
    List<Destino> findAll();
    void delete(Destino destino);
}
