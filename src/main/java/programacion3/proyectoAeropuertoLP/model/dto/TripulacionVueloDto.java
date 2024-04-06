package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Tripulacion;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

@Data
@ToString
@Builder
public class TripulacionVueloDto {

    private Integer id;
    private Tripulacion tripulacionId;
    private Vuelo numeroVueloId;
}
