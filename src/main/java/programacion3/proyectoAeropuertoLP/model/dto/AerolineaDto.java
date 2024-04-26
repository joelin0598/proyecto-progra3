package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import programacion3.proyectoAeropuertoLP.model.entity.UsuarioAerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.model.entity.AvionAerolinea;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
    private List<AvionAerolinea> avionesAerolineaList;
    private List<Vuelo> aerolineasList;
    private List<Destino> destinosList;
    private List<UsuarioAerolinea> usuarioAerolineasList;
}
