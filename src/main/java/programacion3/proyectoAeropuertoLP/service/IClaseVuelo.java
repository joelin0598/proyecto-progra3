package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.ClaseVuelo;

import java.util.List;

public interface IClaseVuelo {
    ClaseVuelo save(ClaseVuelo claseVuelo);
    ClaseVuelo update(ClaseVuelo claseVuelo);
    ClaseVuelo findById(Integer id);
    void delete(ClaseVuelo claseVuelo);
    List<ClaseVuelo> findAll();
}
