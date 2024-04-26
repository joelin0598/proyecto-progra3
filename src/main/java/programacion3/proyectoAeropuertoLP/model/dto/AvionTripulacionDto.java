package programacion3.proyectoAeropuertoLP.model.dto;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.model.entity.EstadoAsignacion;
import programacion3.proyectoAeropuertoLP.model.entity.Tripulacion;

import java.sql.Timestamp;

@Data
@ToString
@Builder
public class AvionTripulacionDto {

    private Integer id;
    private Avion avionId;
    private Tripulacion tripulacionId;
    private Timestamp fechaAsignacion;
    private EstadoAsignacion estadoAsignacionId;
}
