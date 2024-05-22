package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "aeropuertoSalidaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloSalidaList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aeropuertoLlegadaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloLlegadaList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aeropuertoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Destino> destinoList = new ArrayList<>();
}