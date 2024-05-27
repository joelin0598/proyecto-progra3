package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.BaseEntity;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
 public class Boleto extends BaseEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Integer id;

 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name = "cliente_id",referencedColumnName = "id")
 private Cliente clienteId;

 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name = "numero_vuelo_id",referencedColumnName = "id")
 private Vuelo numeroVueloId;

 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
 @JoinColumn(name = "clase_vuelo_id",referencedColumnName = "id")
 private ClaseVuelo claseVueloId;

 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name="asiento_id",referencedColumnName = "id")
 private Asientos asientoId;

 @Column(name = "cantidad_maletas")
 private int cantidadMaletas;
}
