package programacion3.proyectoAeropuertoLP.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion3.proyectoAeropuertoLP.model.entity.Boleto;

public interface BoletoDao extends JpaRepository<Boleto, Integer> {
}
