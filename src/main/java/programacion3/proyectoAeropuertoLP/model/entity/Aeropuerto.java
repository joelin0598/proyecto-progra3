package programacion3.proyectoAeropuertoLP.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @OneToMany(mappedBy = "aeropuertoSalidaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloSalidaList = new ArrayList<>();

    @OneToMany(mappedBy = "aeropuertoLlegadaId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vuelo> numeroVueloLlegadaList = new ArrayList<>();

    @OneToMany(mappedBy = "aeropuertoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Destino> destinoList = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        asignarValorPorDefecto();
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
        asignarValorPorDefecto();
    }

    private void asignarValorPorDefecto() {
        if (this.creadoPor == null || this.creadoPor.isEmpty()) {
            this.creadoPor = "Sistema";
        }
        if (this.modificadoPor == null || this.modificadoPor.isEmpty()) {
            this.modificadoPor = "Sistema";
        }
    }
}