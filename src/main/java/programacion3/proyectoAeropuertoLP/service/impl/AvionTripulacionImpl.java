package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.AvionTripulacionDao;
import programacion3.proyectoAeropuertoLP.model.entity.AvionTripulacion;
import programacion3.proyectoAeropuertoLP.service.IAvionTripulacion;

import java.util.List;

@Service
public class AvionTripulacionImpl implements IAvionTripulacion {

    @Autowired
    private AvionTripulacionDao avionTripulacionDao;

    @Transactional
    @Override
    public AvionTripulacion save(AvionTripulacion avionTripulacion) {
        return avionTripulacionDao.save(avionTripulacion);
    }

    @Transactional
    @Override
    public AvionTripulacion update(AvionTripulacion avionTripulacion) {
        return avionTripulacionDao.save(avionTripulacion);
    }

    @Transactional(readOnly = true)
    @Override
    public AvionTripulacion findById(Integer id) {
        return avionTripulacionDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvionTripulacion> findAll() {
        return (List<AvionTripulacion>) avionTripulacionDao.findAll();
    }

    @Transactional
    @Override
    public void delete(AvionTripulacion avionTripulacion) {
        avionTripulacionDao.delete(avionTripulacion);
    }
}
