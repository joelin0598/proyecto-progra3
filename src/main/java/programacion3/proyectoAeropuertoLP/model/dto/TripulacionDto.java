package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.TripulacionVuelo;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
public class TripulacionDto {

    private Integer id;
    private String nombre;
    private String tipoPuesto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    private List<TripulacionVuelo> tripulacionVueloList;
}
