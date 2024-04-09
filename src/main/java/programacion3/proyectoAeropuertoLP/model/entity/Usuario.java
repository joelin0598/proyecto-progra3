
package programacion3.proyectoAeropuertoLP.model.entity;

        import jakarta.persistence.*;
        import lombok.*;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "usuarioId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UsuarioAerolinea> usuarioAerolineaList = new ArrayList<>();

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;
}
