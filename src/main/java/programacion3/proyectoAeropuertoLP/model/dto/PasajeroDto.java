package programacion3.proyectoAeropuertoLP.model.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.io.Serializable;

@Data
@ToString
@Builder
public class PasajeroDto{

    @NotBlank
    @NotEmpty
    @Size(max = 15, message = "El campo debe tener como máximo {max} caracteres")
    private String pasaporte;

    @NotBlank
    @NotEmpty
    private String nombres;

    @NotBlank
    @NotEmpty
    private String apellidos;

    @NotBlank
    @NotEmpty
    private String fechaNacimiento;

    private String nation;

    @NotBlank
    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @NotEmpty
    private String codigoAreaPais;

    @NotBlank
    @NotEmpty
    @Size(max = 8)
    private String tel;

    @NotBlank
    @NotEmpty
    @Size(max = 8)
    private String telEmergencias;

    @NotBlank
    @NotEmpty
    private String direccion;

    @NotBlank
    @NotEmpty
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$", message = "El formato de la contraseña no es válido")
    private String password;
}
