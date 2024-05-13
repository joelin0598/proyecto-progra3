package programacion3.proyectoAeropuertoLP.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.time.LocalDateTime;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VueloDto {

    private Integer id;

    @NotNull
    private Integer aerolineaId;

    @NotNull
    private Integer avionId;

    @NotNull
    private Integer aeropuertoSalidaId;

    @NotNull
    private Integer aeropuertoLlegadaId;

    @NotNull
    @Positive
    private Integer asientosDisponibles;

    @NotNull
    private LocalDateTime fechaHoraSalida;

    @NotNull
    private LocalDateTime fechaHoraLlegada;

    @NotNull
    @Positive
    private Float precioClaseEconomica;

    @NotNull
    @Positive
    private Float precioClaseEjecutiva;
}