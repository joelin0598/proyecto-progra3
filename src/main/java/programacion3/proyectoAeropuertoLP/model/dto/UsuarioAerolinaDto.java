package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;

import java.io.Serializable;
@Data
@ToString
@Builder
public class UsuarioAerolinaDto implements Serializable {
    private Integer id;
    private Usuario usuarioId;
    private Aerolinea aerolineaId;
}
