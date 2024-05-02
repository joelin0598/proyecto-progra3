package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.EstadoAsignacionDao;
import programacion3.proyectoAeropuertoLP.model.entity.EstadoAsignacion;
import programacion3.proyectoAeropuertoLP.service.IEstadoAsignacion;

import java.util.List;

@Service
public class EstadoAsignacionImpl implements IEstadoAsignacion {

    @Autowired
    private EstadoAsignacionDao estadoAsignacionDao;

    @Transactional
    @Override
    public EstadoAsignacion save(EstadoAsignacion estadoAsignacion) {
        return estadoAsignacionDao.save(estadoAsignacion);
    }

    @Transactional
    @Override
    public EstadoAsignacion update(EstadoAsignacion estadoAsignacion) {
        return estadoAsignacionDao.save(estadoAsignacion);
    }

    @Transactional(readOnly = true)
    @Override
    public EstadoAsignacion findById(Integer id) {
        return estadoAsignacionDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstadoAsignacion> findAll() {
        return (List<EstadoAsignacion>) estadoAsignacionDao.findAll();
    }

    @Transactional
    @Override
    public void delete(EstadoAsignacion estadoAsignacion) {
        estadoAsignacionDao.delete(estadoAsignacion);
    }
}
