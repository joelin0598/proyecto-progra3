package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.dto.VueloDto;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

import java.util.List;

public interface IVuelo {

    Vuelo save(Vuelo vuelo);
    Vuelo update(Vuelo vuelo);
    Vuelo findById(Integer id);
    List<Vuelo> findAll();
    void delete(Vuelo vuelo);

    /*VueloDto findById(Integer id);*/

    /*List<VueloDto> findAll();*/


}
