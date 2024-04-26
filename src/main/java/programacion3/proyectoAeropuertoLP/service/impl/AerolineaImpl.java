package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.AerolineaDao;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.service.IAerolinea;

import java.util.List;

@Service
public class AerolineaImpl implements IAerolinea {

    @Autowired
    private AerolineaDao aerolineaDao;

    @Transactional
    @Override
    public Aerolinea save(Aerolinea aerolinea){
        return aerolineaDao.save(aerolinea);
    }

    @Transactional
    @Override
    public Aerolinea update(Aerolinea aerolinea) {
        return aerolineaDao.save(aerolinea);
    }

    @Transactional(readOnly = true)
    @Override
    public Aerolinea findById(Integer id){
        return aerolineaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aerolinea> findAll() {
        return (List<Aerolinea>) aerolineaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public void delete(Aerolinea aerolinea) {
        aerolineaDao.delete(aerolinea);
    }
}
