package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
@Builder
public class AvionDto{
    private Integer id;
    private boolean estado;
    private String modelo;
    private String marca;
    private Integer anio;
    private Integer maxAsientos;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    private List<Vuelo> vuelosAerolineaList;
}
