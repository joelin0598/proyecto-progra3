package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.ClaseVueloDao;
import programacion3.proyectoAeropuertoLP.model.entity.ClaseVuelo;
import programacion3.proyectoAeropuertoLP.service.IClaseVuelo;

import java.util.List;

@Service
public class ClaseVueloImpl implements IClaseVuelo {
    @Autowired
    private ClaseVueloDao claseVueloDao;

    @Transactional
    @Override
    public ClaseVuelo save(ClaseVuelo claseVuelo) {
        return claseVueloDao.save(claseVuelo);
    }

    @Transactional
    @Override
    public ClaseVuelo update(ClaseVuelo claseVuelo) {
        return claseVueloDao.save(claseVuelo);
    }

    @Transactional(readOnly = true)
    @Override
    public ClaseVuelo findById(Integer id) {
        return claseVueloDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClaseVuelo> findAll() {
        return (List<ClaseVuelo>) claseVueloDao.findAll();
    }

    @Transactional
    @Override
    public void delete(ClaseVuelo claseVuelo) {
        claseVueloDao.delete(claseVuelo);
    }
}
