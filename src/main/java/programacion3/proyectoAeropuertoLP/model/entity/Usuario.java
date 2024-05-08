
package programacion3.proyectoAeropuertoLP.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rol_id;

    @Column(name = "pasaporte", unique = true)
    private String pasaporte;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "nacionalidad")
    private String nation;

    @Column(name = "correo_electronico")
    private String email;

    @Column(name = "codigo_area_pais")
    private String codigoAreaPais;

    @Column(name = "telefono")
    private String tel;

    @Column(name = "telefono_emergencias")
    private String telEmergencias;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "password")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$", message = "El formato de la contraseña no es válido")
    private String password;

    @OneToMany(mappedBy = "usuarioId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();

    @OneToMany(mappedBy = "pilotoId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> pilotoList = new ArrayList<>();

    @OneToMany(mappedBy = "copilotoId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> copilotoList = new ArrayList<>();

    @OneToMany(mappedBy = "ingenieroId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> ingenieroList = new ArrayList<>();

    @OneToMany(mappedBy = "tripulante1Id",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> tripulante1List = new ArrayList<>();

    @OneToMany(mappedBy = "tripulante2Id",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> tripulante2List = new ArrayList<>();

    @OneToMany(mappedBy = "tripulante3Id",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tripulacion> tripulante3List = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UsuarioAerolinea> usuarioAerolineaList = new ArrayList<>();
}
