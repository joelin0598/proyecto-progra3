package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private Users usersId;

    @JsonIgnore
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

    @Size(max = 100)
    @Column(name = "nombres", length = 100)
    private String nombres;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Size(max = 100)
    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @Size(max = 100)
    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Size(max = 5)
    @Column(name = "pais", length = 5)
    private String pais;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Size(max = 100)
    @Column(name = "creado_por", length = 100)
    private String creadoPor;

    @Size(max = 100)
    @Column(name = "modificado_por", length = 100)
    private String modificadoPor;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        asignarValorPorDefecto();
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
        asignarValorPorDefecto();
    }

    private void asignarValorPorDefecto() {
        if (this.creadoPor == null || this.creadoPor.isEmpty()) {
            this.creadoPor = "Sistema";
        }
        if (this.modificadoPor == null || this.modificadoPor.isEmpty()) {
            this.modificadoPor = "Sistema";
        }
    }

}