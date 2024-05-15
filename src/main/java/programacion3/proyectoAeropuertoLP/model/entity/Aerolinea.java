package programacion3.proyectoAeropuertoLP.model.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloList = new ArrayList<>();

    //ok
    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Destino> destinosList = new ArrayList<>();

    //ok
    @OneToMany(mappedBy = "aerolineaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avion> avionList = new ArrayList<>();

    //ok
    @OneToMany(mappedBy = "aerolineaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> tripulacionList = new ArrayList<>();
}
