package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {
}
