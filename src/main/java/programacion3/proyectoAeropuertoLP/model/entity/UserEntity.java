package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
@Table(name = "users")
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rol;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @Size(max = 255)
    @Column(name = "nickname")
    private String nickname;

    @Size(max = 255)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;


    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> clienteList = new ArrayList<>();

    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleados> empleadosList = new ArrayList<>();

}