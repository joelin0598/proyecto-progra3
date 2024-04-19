package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="avion")
public class AvionTripulacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "avion_id",referencedColumnName = "id")
    private Avion avionId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "tripulacion_id",referencedColumnName = "id")
    private Tripulacion tripulacionId;

    @Column(name = "fecha_asignacion")
    private Timestamp fechaAsignacion;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_asignacion_id",referencedColumnName = "id")
    private EstadoAsignacion estadoAsignacionId;
}
