package programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import programacion3.proyectoAeropuertoLP.config.SecurityUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Column(name = "fecha_creacion", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'Sistema'")
    private String creadoPor;

    @Column(name = "modificado_por", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'Sistema'")
    private String modificadoPor;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
        if (this.creadoPor == null || this.creadoPor.isEmpty()) {
            this.creadoPor = SecurityUtil.getCurrentUser();
            if (this.creadoPor.equals("Sistema")) {
                this.creadoPor = "Auto-Registro";
            }
        }
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
        this.modificadoPor = SecurityUtil.getCurrentUser();
    }
}