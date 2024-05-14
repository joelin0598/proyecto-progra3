package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.ClaseVuelo;
import programacion3.proyectoAeropuertoLP.model.entity.Cliente;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

@Data
@ToString
@Builder
 public class BoletoDto {

 private Integer id;
 private Cliente clienteId;
 private Vuelo numeroVueloId;
 private ClaseVuelo claseVueloId;
 private String asientos;
 private int cantidadMaletas;
}
