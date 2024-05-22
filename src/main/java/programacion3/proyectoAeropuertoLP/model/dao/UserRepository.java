package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findUserByEmail(String email);
}
