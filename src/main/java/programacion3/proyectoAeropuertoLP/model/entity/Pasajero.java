package programacion3.proyectoAeropuertoLP.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pasaporte")
    private String pasaporte;

    @Column(name = "nacionalidad")
    private String nation;

    @Column(name = "edad")
    private int edad;

    @Column(name = "telefono")
    private String tel;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "pasajeroId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();
}
