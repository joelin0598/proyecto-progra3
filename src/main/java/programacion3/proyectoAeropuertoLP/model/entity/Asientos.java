package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="asientos")
public class Asientos extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "avion_id",referencedColumnName = "id")
    private Avion avionId;

    @Column(name = "fila")
    private int fila;

    @Column(name = "columna")
    private int columna;

    @Column(name = "ocupado")
    private boolean ocupado;

    @OneToMany(mappedBy = "asientoId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Boleto> boletoList = new ArrayList<>();
}
