package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "vuelo")
public class Vuelo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "aerolinea_id",referencedColumnName = "id")
    private Aerolinea aerolineaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aeropuerto_salida_id",referencedColumnName = "id")
    private Aeropuerto aeropuertoSalidaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "aeropuerto_llegada_id",referencedColumnName = "id")
    private Aeropuerto aeropuertoLlegadaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "avion_id",referencedColumnName = "id")
    private Avion avionId;

    @Column(name = "asientos_disponibles")
    private Integer asientosDisponibles;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;

    @Column(name = "fecha_hora_llegada")
    private LocalDateTime fechaHoraLlegada;

    @Column(name = "precio_clase_economica")
    private float precioClaseEconomica;

    @Column(name = "precio_clase_ejecutiva")
    private float precioClaseEjecutiva;

    @OneToMany(mappedBy = "numeroVueloId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();
}
