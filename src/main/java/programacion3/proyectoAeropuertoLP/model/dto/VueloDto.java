package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Boleto;
import programacion3.proyectoAeropuertoLP.model.entity.TripulacionVuelo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
public class VueloDto {

    private Integer id;
    private int aerolineaId;
    private Aeropuerto aeropuertoSalidaId;
    private Aeropuerto aeropuertoLlegadaId;
    private int avionId;
    private LocalDate fechaHoraSalida;
    private LocalDateTime fechaHoraLlegada;
    private float precioClaseEconomica;
    private float precioClaseEjecutiva;
    private List<Boleto> boletoList;
    private List<TripulacionVuelo> tripulacionVueloList;
}
