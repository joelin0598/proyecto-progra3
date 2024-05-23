package programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
        if (this.creadoPor == null || this.creadoPor.isEmpty()) {
            this.creadoPor = "Sistema";
        }
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
        if (this.modificadoPor == null || this.modificadoPor.isEmpty()) {
            this.modificadoPor = "Sistema";
        }
    }
}