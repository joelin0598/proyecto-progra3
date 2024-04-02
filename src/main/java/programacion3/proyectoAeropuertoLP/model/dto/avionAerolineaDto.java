package programacion3.proyectoAeropuertoLP.model.dto;


import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class avionAerolineaDto implements Serializable {
    private Integer id;
    private Integer avionId;
    private Integer aerolineaId;

}
