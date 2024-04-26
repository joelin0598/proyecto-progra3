package programacion3.proyectoAeropuertoLP.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "pasajero")
public class Pasajero{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

    @OneToMany(mappedBy = "pasajeroId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();
}
