package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ToString
@Builder
public class AvionDto implements Serializable {
    private Integer id;
    private String modelo;
    private String marca;
    private Integer anio;
    private Integer capacidadPasajeros;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
}
