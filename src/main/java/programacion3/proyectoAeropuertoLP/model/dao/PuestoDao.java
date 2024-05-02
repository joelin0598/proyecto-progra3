package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Puesto;

public interface PuestoDao extends JpaRepository<Puesto, Integer> {
}
