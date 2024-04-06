package programacion3.proyectoAeropuertoLP.model.dto;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.Boleto;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
public class PasajeroDto {

    private Integer id;
    private String nombre;
    private String pasaporte;
    private String nation;
    private int edad;
    private String tel;
    private String email;
    private List<Boleto> boletoList;
}
