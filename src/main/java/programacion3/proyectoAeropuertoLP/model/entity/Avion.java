package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="avion")
public class Avion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "aerolinea_id",referencedColumnName = "id")
    private Aerolinea aerolineaId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "tripulacion_id",referencedColumnName = "id")
    private Tripulacion tripulacionId;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "max_asientos")
    private Integer maxAsientos;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @OneToMany(mappedBy = "avionId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloList = new ArrayList<>();

    @OneToMany(mappedBy = "avionId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Asientos> asientosList = new ArrayList<>();
}
