package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.TripulacionDao;
import programacion3.proyectoAeropuertoLP.model.entity.Tripulacion;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;

import java.util.List;

@Service
public class TripulacionImpl implements CrudServiceProcessingController<Tripulacion, Integer>{

    @Autowired
    private TripulacionDao tripulacionDao;
    @Transactional
    @Override
    public Tripulacion save(Tripulacion tripulacion) {
        return tripulacionDao.save(tripulacion);
    }

    @Transactional
    @Override
    public Tripulacion update(Tripulacion tripulacion) {
        return tripulacionDao.save(tripulacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Tripulacion findById(Integer id) {
        return tripulacionDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tripulacion> findAll() {
        return (List<Tripulacion>) tripulacionDao.findAll();
    }

    @Override
    public Tripulacion findByNombre(String nombre) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Tripulacion tripulacion) {
        tripulacionDao.delete(tripulacion);
    }
}
