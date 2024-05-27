package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.EstadoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Estado;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;

import java.util.List;

@Service
public class EstadoImpl implements CrudServiceProcessingController<Estado, Integer>{

    @Autowired
    private EstadoDao estadoDao;

    @Transactional
    @Override
    public Estado save(Estado estado) {
        return estadoDao.save(estado);
    }

    @Transactional
    @Override
    public Estado update(Estado estado) {
        return estadoDao.save(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public Estado findById(Integer id) {
        return estadoDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Estado> findAll() {
        return (List<Estado>) estadoDao.findAll();
    }

    @Override
    public Estado findByNombre(String nombre) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Estado estado) {
        estadoDao.delete(estado);
    }
}
