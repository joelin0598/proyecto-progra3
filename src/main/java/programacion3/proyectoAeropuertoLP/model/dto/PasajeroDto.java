package programacion3.proyectoAeropuertoLP.model.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.io.Serializable;

@Data
@ToString
@Builder
public class PasajeroDto implements Serializable {

    @NotBlank
    @Size(max = 15, message = "El campo debe tener como máximo {max} caracteres")
    private String pasaporte;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String fechaNacimiento;

    private String nation;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    private String codigoAreaPais;

    @NotBlank
    @Size(max = 8)
    private String tel;

    @NotBlank
    @Size(max = 8)
    private String telEmergencias;

    @NotBlank
    private String direccion;

    @NotBlank
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$", message = "El formato de la contraseña no es válido")
    private String password;
}
