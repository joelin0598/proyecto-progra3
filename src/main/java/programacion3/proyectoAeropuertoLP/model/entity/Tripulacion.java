package programacion3.proyectoAeropuertoLP.model.entity;

import jakarta.persistence.*;
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
@Table(name = "tripulacion")
public class Tripulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_puesto")
    private String tipoPuesto;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @OneToMany(mappedBy = "tripulacionId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TripulacionVuelo> tripulacionVueloList = new ArrayList<>();

    @OneToMany(mappedBy = "tripulacionId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AvionTripulacion> avionTripulacionList = new ArrayList<>();
}
