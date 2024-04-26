package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.AvionAerolineaDao;
import programacion3.proyectoAeropuertoLP.model.entity.AvionAerolinea;
import programacion3.proyectoAeropuertoLP.service.IAvionAerolinea;

import java.util.List;

@Service
public class AvionAerolineaImpl implements IAvionAerolinea {
    @Autowired
    private AvionAerolineaDao avionAerolineaDao;

    @Transactional
    @Override
    public AvionAerolinea save(AvionAerolinea avionAerolinea) {
        return avionAerolineaDao.save(avionAerolinea);
    }

    @Transactional
    @Override
    public AvionAerolinea update(AvionAerolinea avionAerolinea) {
        return avionAerolineaDao.save(avionAerolinea);
    }

    @Transactional(readOnly = true)
    @Override
    public AvionAerolinea findById(Integer id) {
        return avionAerolineaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvionAerolinea> findAll() {
        return (List<AvionAerolinea>) avionAerolineaDao.findAll();
    }

    @Transactional
    @Override
    public void delete(AvionAerolinea avionAerolinea) {
        avionAerolineaDao.delete(avionAerolinea);
    }
}
