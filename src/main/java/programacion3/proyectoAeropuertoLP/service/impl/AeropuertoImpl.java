package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.AeropuertoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.service.IAeropuerto;

import java.util.List;

@Service
public class AeropuertoImpl implements IAeropuerto {

    @Autowired
    private AeropuertoDao aeropuertoDao;

    @Transactional
    @Override
    public Aeropuerto save(Aeropuerto aeropuerto) {
        return aeropuertoDao.save(aeropuerto);
    }

    @Transactional
    @Override
    public Aeropuerto update(Aeropuerto aeropuerto) {
        return aeropuertoDao.save(aeropuerto);
    }

    @Transactional(readOnly = true)
    @Override
    public Aeropuerto findById(Integer id) {
        return  aeropuertoDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aeropuerto> findAll() {
        return (List<Aeropuerto>) aeropuertoDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Aeropuerto aeropuerto) {
        aeropuertoDao.delete(aeropuerto);
    }
}
