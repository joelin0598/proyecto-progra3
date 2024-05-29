package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "empleados")
public class Empleados extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombres")
    private String firstName;

    @Column(name = "apellidos")
    private String lastName;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private User userId;

    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "puesto_id",referencedColumnName = "id")
    private Puesto puestoId;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tripulacion_id",referencedColumnName = "id")
    private Tripulacion tripulacionId;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aerolinea_id",referencedColumnName = "id")
    private Aeropuerto aerolineaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Size(max = 100)
    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @Size(max = 5)
    @Column(name = "pais", length = 5)
    private String pais;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;
}