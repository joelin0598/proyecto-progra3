package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.UsuarioAerolinea;

public interface UsuarioAerolineaDao extends JpaRepository<UsuarioAerolinea, Integer> {
}
