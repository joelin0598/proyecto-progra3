package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.DestinoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;
import programacion3.proyectoAeropuertoLP.service.IDestino;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoImpl implements IDestino {

    @Autowired
    private DestinoDao destinoDao;

    @Transactional
    @Override
    public Destino save(Destino destino) {
        return destinoDao.save(destino);
    }

    @Override
    public Destino update(Destino destino) {
        return destinoDao.save(destino);
    }

    @Transactional(readOnly = true)
    @Override
    public Destino findById(Integer id) {
        return destinoDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Destino> findAll() {
        return (List<Destino>) destinoDao.findAll();
    }

    @Override
    public Destino findByNombre(String nombre) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Destino destino) {
        destinoDao.delete(destino);
    }

    @Transactional(readOnly = true)
    public List<Aeropuerto> findAeropuertosByAerolinea(Aerolinea aerolinea) {
        List<Destino> destinos = destinoDao.findByAerolineaId(aerolinea);
        return destinos.stream()
                .map(Destino::getAeropuertoId)
                .distinct()
                .collect(Collectors.toList());
    }
}
