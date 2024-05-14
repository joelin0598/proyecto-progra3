package programacion3.proyectoAeropuertoLP.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

 @Column(name = "fecha_creacion")
 private LocalDateTime fechaCreacion;

 @Column(name = "fecha_modificacion")
 private LocalDateTime fechaModificacion;

 @Column(name = "creado_por")
 private String creadoPor;

 @Column(name = "modificado_por")
 private String modificadoPor;
}
