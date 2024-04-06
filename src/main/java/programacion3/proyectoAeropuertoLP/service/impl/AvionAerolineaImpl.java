package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.AvionAerolineaDao;
import programacion3.proyectoAeropuertoLP.model.entity.AvionAerolinea;
import programacion3.proyectoAeropuertoLP.service.IAvionAerolinea;

import java.util.List;

@Service
public class AvionAerolineaImpl implements IAvionAerolinea {
    @Autowired
    private AvionAerolineaDao avionAerolineaDao;

    @Override
    public AvionAerolinea save(AvionAerolinea avionAerolinea) {
        return avionAerolineaDao.save(avionAerolinea);
    }

    @Override
    public AvionAerolinea findById(Integer id) {
        return avionAerolineaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(AvionAerolinea avionAerolinea) {
        avionAerolineaDao.delete(avionAerolinea);
    }

    @Override
    public List<AvionAerolinea> findAll() {
        return avionAerolineaDao.findAll();
    }
}
