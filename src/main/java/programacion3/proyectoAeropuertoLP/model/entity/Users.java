package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rolId;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "email_verifiqued_at")
    private String emailVerifiquedAt;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @Size(max = 255)
    @Column(name = "remembeer_token")
    private String remembeerToken;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarioList = new ArrayList<>();

    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleado> empleadoList = new ArrayList<>();

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