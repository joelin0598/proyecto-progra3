    package programacion3.proyectoAeropuertoLP.model.dao;

    import org.springframework.data.jpa.repository.JpaRepository;
    import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
    import programacion3.proyectoAeropuertoLP.model.entity.Avion;

    import java.util.List;

    public interface AvionDao extends JpaRepository<Avion, Integer> {
        List<Avion> findByAerolineaId(Aerolinea aerolinea);
    }

