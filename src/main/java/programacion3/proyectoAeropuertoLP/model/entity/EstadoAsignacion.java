package programacion3.proyectoAeropuertoLP.model.entity;
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
@Table(name ="estado_asignacion")
public class EstadoAsignacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @OneToMany(mappedBy = "estadoAsignacionId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AvionTripulacion> avionTripulacionList = new ArrayList<>();
}
