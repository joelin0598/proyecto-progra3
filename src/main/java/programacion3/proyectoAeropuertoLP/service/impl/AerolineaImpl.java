package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.AerolineaDao;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.service.IAerolinea;

import java.util.List;

@Service
public class AerolineaImpl implements IAerolinea {

    @Autowired
    private AerolineaDao aerolineaDao;

    @Override
    public Aerolinea save(Aerolinea aerolinea){
        return aerolineaDao.save(aerolinea);
    }
    @Override
    public Aerolinea findById(Integer id){
        return aerolineaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Aerolinea aerolinea) {
        aerolineaDao.delete(aerolinea);
    }
    @Override
    public List<Aerolinea> findAll() {
        return aerolineaDao.findAll();
    }


}
