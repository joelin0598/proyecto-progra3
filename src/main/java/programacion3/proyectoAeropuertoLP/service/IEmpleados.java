package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Empleados;

import java.util.List;

public interface IEmpleados {
    Empleados save(Empleados empleados);
    Empleados update(Empleados empleados);
    Empleados findById(Integer id);
    List<Empleados> findAll();
    void delete(Empleados empleados);
}
