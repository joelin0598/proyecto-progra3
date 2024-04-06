package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.PasajeroDao;
import programacion3.proyectoAeropuertoLP.model.entity.Pasajero;
import programacion3.proyectoAeropuertoLP.service.IPasajero;

import java.util.List;

@Service
public class PasajeroImpl implements IPasajero {
    @Autowired
    private PasajeroDao pasajeroDao;
    @Transactional
    @Override
    public Pasajero save(Pasajero pasajero) {
        return pasajeroDao.save(pasajero);
    }

    @Transactional
    @Override
    public Pasajero update(Pasajero pasajero) {
        return pasajeroDao.save(pasajero);
    }

    @Transactional(readOnly = true)
    @Override
    public Pasajero findById(Integer id) {
        return pasajeroDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delte(Pasajero pasajero) {
        pasajeroDao.delete(pasajero);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pasajero> findAll() {
        return (List<Pasajero>) pasajeroDao.findAll();
    }
}
