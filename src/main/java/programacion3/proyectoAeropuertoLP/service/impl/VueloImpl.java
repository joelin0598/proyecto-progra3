package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.AerolineaDao;
import programacion3.proyectoAeropuertoLP.model.dao.AvionDao;
import programacion3.proyectoAeropuertoLP.model.dao.VueloDao;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.service.IVuelo;

import java.util.List;

@Service
public class VueloImpl implements IVuelo {
    @Autowired
    private VueloDao vueloDao;

    @Autowired
    private AerolineaDao aerolineaDao;

    @Autowired
    private AvionDao avionDao;

    @Transactional
    @Override
    public Vuelo save(Vuelo vuelo){
        return vueloDao.save(vuelo);
    }

    @Transactional
    @Override
    public Vuelo update(Vuelo vuelo) {
        return vueloDao.save(vuelo);
    }

    @Transactional(readOnly = true)
    @Override
    public Vuelo findById(Integer id) {
        return vueloDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vuelo> findAll() {
        return (List<Vuelo>) vueloDao.findAll();
    }

    @Transactional
    @Override
    public boolean validarAerolineaConAvionesActivos(Integer aerolineaId) {
        return avionDao.consultarEstadoAvionesPorAerolinea(aerolineaId);
    }

    @Transactional
    @Override
    public void delete(Vuelo vuelo) {

    }
}
