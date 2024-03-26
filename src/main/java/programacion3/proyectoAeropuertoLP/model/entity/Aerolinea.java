
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
@Table(name ="aerolinea")
public class Aerolinea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

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
