package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.DestinoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;


import java.util.List;

@Service
public class DestinoImpl implements CrudServiceProcessingController<Destino, Integer>{

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
}
