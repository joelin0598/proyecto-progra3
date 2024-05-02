package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Asientos;

import java.util.List;

public interface IAsientos {
    Asientos save(Asientos asientos);
    Asientos update(Asientos asientos);
    Asientos findById(int id);
    List<Asientos> findAll();
    void delete(Asientos asientos);
}
