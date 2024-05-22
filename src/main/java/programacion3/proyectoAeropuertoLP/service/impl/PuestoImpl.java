package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.PuestoDao;
import programacion3.proyectoAeropuertoLP.model.entity.Puesto;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;

import java.util.List;

@Service
public class PuestoImpl implements CrudServiceProcessingController<Puesto, Integer>{

    @Autowired
    private PuestoDao puestoDao;

    @Transactional
    @Override
    public Puesto save(Puesto puesto) {
        return puestoDao.save(puesto);
    }

    @Transactional
    @Override
    public Puesto update(Puesto puesto) {
        return puestoDao.save(puesto);
    }

    @Transactional(readOnly = true)
    @Override
    public Puesto findById(Integer id) {
        return puestoDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Puesto> findAll() {
        return (List<Puesto>) puestoDao.findAll();
    }

    @Override
    public Puesto findByNombre(String nombre) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Puesto puesto) {
        puestoDao.delete(puesto);
    }
}
