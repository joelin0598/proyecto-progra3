package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.AvionDao;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.service.IAvion;

import java.util.List;

@Service
public class AvionImpl implements IAvion {

    @Autowired
    private AvionDao avionDao;

    @Override
    public Avion save(Avion avion) {
        return avionDao.save(avion);
    }

    @Override
    public Avion findById(Integer id) {
        return avionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Avion avion) {
        avionDao.delete(avion);
    }

    @Override
    public List<Avion> findAll() {
        return avionDao.findAll();
    }
}
