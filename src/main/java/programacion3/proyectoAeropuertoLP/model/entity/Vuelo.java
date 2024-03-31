package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "aerolinea_id")
    private int aerolineaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aeropuerto_salida_id",referencedColumnName = "id")
    private Aeropuerto aeropuertoSalidaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "aeropuerto_llegada_id",referencedColumnName = "id")
    private Aeropuerto aeropuertoLlegadaId;

    @Column(name = "avion_id")
    private int avionId;

    @Column(name = "fecha_hora_salida")
    private LocalDate fechaHoraSalida;

    @Column(name = "fecha_hora_llegada")
    private LocalDateTime fechaHoraLlegada;

    @Column(name = "precio_clase_economica")
    private float precioClaseEconomica;

    @Column(name = "precio_clase_ejecutiva")
    private float precioClaseEjecutiva;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "numero_vuelo_id",referencedColumnName = "id")
    private List<Boleto> boletoList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tripulacion_id",referencedColumnName = "id")
    private List<AsignacionTV> asignacionTVList = new ArrayList<>();
}
