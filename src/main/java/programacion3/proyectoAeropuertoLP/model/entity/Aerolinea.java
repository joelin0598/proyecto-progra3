package programacion3.proyectoAeropuertoLP.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="aerolinea")
public class Aerolinea extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Destino> destinosList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avion> avionList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aerolineaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> tripulacionList = new ArrayList<>();
}
