package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tripulacion")
public class Tripulacion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aerolinea_id",referencedColumnName = "id")
    private Aerolinea aerolineaId;

    @OneToMany(mappedBy = "tripulacionId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avion> avionList = new ArrayList<>();

    @OneToMany(mappedBy = "tripulacionId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Empleados> empleadosList = new ArrayList<>();

    @OneToMany(mappedBy = "tripulacion",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Vuelo> vueloList = new ArrayList<>();

}
