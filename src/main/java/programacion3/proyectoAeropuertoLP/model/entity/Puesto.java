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
@Table(name ="puesto")
public class Puesto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "puesto_nombre")
    private String puestoNombre;

    @OneToMany(mappedBy = "puestoId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleados> empleadosList = new ArrayList<>();

}
