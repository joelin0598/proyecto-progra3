package programacion3.proyectoAeropuertoLP.model.entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import jakarta.persistence.*;
        import lombok.*;
        import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;

        import java.sql.Timestamp;
        import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name ="destino")
public class Destino extends BaseEntity {
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
    @JoinColumn(name = "aeropuerto_id",referencedColumnName = "id")
    private Aeropuerto aeropuertoId;

    @Column(name = "destino_final")
    private String destinoFinal;

    @Column(name = "descripcion")
    private String descripcion;
}
