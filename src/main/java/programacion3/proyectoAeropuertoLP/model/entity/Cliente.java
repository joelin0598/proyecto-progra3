
package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.User;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="cliente")
public class Cliente extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private User userId;

    @Column(name = "pasaporte", unique = true)
    private String pasaporte;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "nacionalidad")
    private String nation;

    @Column(name = "codigo_area_pais")
    private String codigoAreaPais;

    @Column(name = "telefono")
    private String tel;

    @Column(name = "telefono_emergencias")
    private String telEmergencias;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "clienteId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();

}
