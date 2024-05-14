package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Empleados;

public interface EmpleadosDao extends JpaRepository<Empleados, Integer> {
}
