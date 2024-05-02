package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Rol;

import java.util.List;

public interface IRol {
    Rol save(Rol rol);
    Rol update(Rol rol);
    Rol findById(Integer id);
    List<Rol> findAll();
    void delete(Rol rol);
}
