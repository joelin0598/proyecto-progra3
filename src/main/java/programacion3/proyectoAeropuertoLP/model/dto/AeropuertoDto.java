package programacion3.proyectoAeropuertoLP.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
public class AeropuertoDto{

    private Integer id;
    private String nombre;
    private String ciudad;
    private String pais;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    private List<Vuelo> vueloSalidaList;
    private List<Vuelo> vueloLlegadaList;
}
