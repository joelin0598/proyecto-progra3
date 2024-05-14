package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.model.dao.EmpleadosDao;
import programacion3.proyectoAeropuertoLP.model.entity.Empleados;
import programacion3.proyectoAeropuertoLP.service.IEmpleados;

import java.util.List;

@Service
public class EmpleadosImpl implements IEmpleados {

    @Autowired
    private EmpleadosDao empleadosDao;

    @Transactional
    @Override
    public Empleados save(Empleados empleados) {
        return empleadosDao.save(empleados);
    }

    @Override
    public Empleados update(Empleados empleados) {
        return empleadosDao.save(empleados);
    }

    @Override
    public Empleados findById(Integer id) {
        return empleadosDao.findById(id).orElse(null);
    }

    @Override
    public List<Empleados> findAll() {
        return List.of();
    }

    @Override
    public void delete(Empleados empleados) {

    }
}
