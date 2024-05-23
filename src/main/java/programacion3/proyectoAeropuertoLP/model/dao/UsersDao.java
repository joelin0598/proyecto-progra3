package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.User;

public interface UsersDao extends JpaRepository<User, Integer> {
}
