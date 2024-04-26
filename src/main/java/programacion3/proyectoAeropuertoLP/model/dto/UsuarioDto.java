package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@Builder
public class UsuarioDto{

    private Integer id;
    private String nombre;
    private String tipo;
    
}
