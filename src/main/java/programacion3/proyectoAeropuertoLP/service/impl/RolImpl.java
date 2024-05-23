package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.RolDao;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.Rol;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;

import java.util.List;

@Service
public class RolImpl implements CrudServiceProcessingController<Rol, Integer>{

    private final RolDao rolDao;

    public RolImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

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

    @Override
    public Rol findByNombre(String nombre) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Rol puesto) {
        rolDao.delete(puesto);
    }
}
