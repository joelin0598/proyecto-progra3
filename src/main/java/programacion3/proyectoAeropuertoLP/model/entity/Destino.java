package programacion3.proyectoAeropuertoLP.model.entity;

        import jakarta.persistence.*;
        import lombok.*;
        import java.sql.Timestamp;
        import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="destino")
public class Destino implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "aerolinea_id")
    private Integer aerolineaId;

    @Column(name = "aeropuerto_id")
    private Integer aeropuertoId;

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
}
