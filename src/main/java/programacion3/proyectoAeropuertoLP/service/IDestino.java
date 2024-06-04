package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;

import java.util.List;

public interface IDestino extends CrudServiceProcessingController<Destino, Integer>{
    List<Aeropuerto> findAeropuertosByAerolinea(Aerolinea aerolinea);
    List<Destino> findByAeropuerto(Aeropuerto aeropuerto);
    List<Destino> findByAerolineaId(Integer aerolineaId);
}
