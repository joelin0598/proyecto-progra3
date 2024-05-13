package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Boleto;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
public class ClaseVueloDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
}
