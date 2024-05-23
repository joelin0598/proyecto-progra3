package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.Rol;

public interface RolDao extends JpaRepository<Rol, Integer> {
}
