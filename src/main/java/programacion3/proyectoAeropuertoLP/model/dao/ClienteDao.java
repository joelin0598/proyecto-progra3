package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    boolean existsByPasaporte(String pasaporte);
}
