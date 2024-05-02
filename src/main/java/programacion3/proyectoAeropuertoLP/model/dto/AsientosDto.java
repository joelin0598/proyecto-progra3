package programacion3.proyectoAeropuertoLP.model.dto;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.model.entity.Boleto;
import java.util.List;

@Data
@ToString
@Builder
public class AsientosDto {
    private Integer id;

    private Avion avionId;
    private int fila;
    private int columna;
    private boolean ocupado;
    private List<Boleto> boletoList;
}
