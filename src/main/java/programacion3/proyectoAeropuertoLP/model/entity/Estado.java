package programacion3.proyectoAeropuertoLP.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="estados")
public class Estado extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avion> avionesList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "estadoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Asientos> asientosList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleados> empleadosList = new ArrayList<>();
}
