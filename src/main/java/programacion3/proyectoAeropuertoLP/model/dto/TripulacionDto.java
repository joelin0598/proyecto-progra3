package programacion3.proyectoAeropuertoLP.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
public class TripulacionDto {

    private Integer id;
    private Usuario pilotoId;
    private Usuario copilotoId;
    private Usuario ingenieroId;
    private Usuario tripulante1Id;
    private Usuario tripulante2Id;
    private Usuario tripulante3Id;
}
