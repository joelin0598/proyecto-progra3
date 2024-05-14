package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@Builder
public class AerolineaDto{
    private Integer id;
    private String nombre;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private String creadoPor;
    private String modificadoPor;

}
