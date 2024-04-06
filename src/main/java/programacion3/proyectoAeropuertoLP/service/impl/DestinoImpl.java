package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.DestinoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import programacion3.proyectoAeropuertoLP.service.IDestino;


import java.util.List;

@Service
public class DestinoImpl implements IDestino {
    @Autowired
    private DestinoDao destinoDao;

    @Override
    public Destino save(Destino destino) {
        return destinoDao.save(destino);
    }

    @Override
    public Destino findById(Integer id) {
        return destinoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Destino destino) {
        destinoDao.delete(destino);
    }

    @Override
    public List<Destino> findAll() {
        return destinoDao.findAll();
    }
}
