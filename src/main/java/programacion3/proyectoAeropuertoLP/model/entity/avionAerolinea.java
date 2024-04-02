package programacion3.proyectoAeropuertoLP.model.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="avion_aerolinea")
public class avionAerolinea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "avion_id")
    private Integer avionId;

    @Column(name = "aerolinea_id")
    private Integer aerolineaId;
}
