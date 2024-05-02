package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.RolDao;
import programacion3.proyectoAeropuertoLP.model.entity.Rol;
import programacion3.proyectoAeropuertoLP.service.IRol;

import java.util.List;

@Service
public class RolImpl implements IRol {

    @Autowired
    private RolDao rolDao;

    @Transactional
    @Override
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }

    @Transactional
    @Override
    public Rol update(Rol rol) {
        return rolDao.save(rol);
    }

    @Transactional(readOnly = true)
    @Override
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Rol puesto) {
        rolDao.delete(puesto);
    }
}
