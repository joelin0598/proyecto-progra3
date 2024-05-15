package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.UserEntity;

public interface UsersDao extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByEmail(String email);
}
