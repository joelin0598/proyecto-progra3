package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
 public class Boleto {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Integer id;

 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name = "pasajero_id",referencedColumnName = "id")
 private Pasajero pasajeroId;

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
