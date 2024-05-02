package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@ToString
@Builder
public class EstadoAsignacionDto {

    private Integer id;
    private String nombre;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
}
