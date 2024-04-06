package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.TripulacionVueloDao;
import programacion3.proyectoAeropuertoLP.model.entity.TripulacionVuelo;
import programacion3.proyectoAeropuertoLP.service.ITripulacionVuelo;

import java.util.List;

@Service
public class TripulacionVueloImpl implements ITripulacionVuelo {
    @Autowired
    private TripulacionVueloDao tripulacionVueloDao;

    @Transactional
    @Override
    public TripulacionVuelo save(TripulacionVuelo tripulacionVuelo) {
        return tripulacionVueloDao.save(tripulacionVuelo);
    }

    @Transactional
    @Override
    public TripulacionVuelo update(TripulacionVuelo tripulacionVuelo) {
        return tripulacionVueloDao.save(tripulacionVuelo);
    }

    @Transactional(readOnly = true)
    @Override
    public TripulacionVuelo findById(Integer id) {
        return tripulacionVueloDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TripulacionVuelo> findAll() {
        return (List<TripulacionVuelo>) tripulacionVueloDao.findAll();
    }

    @Transactional
    @Override
    public void delete(TripulacionVuelo tripulacionVuelo) {
        tripulacionVueloDao.delete(tripulacionVuelo);
    }
}
