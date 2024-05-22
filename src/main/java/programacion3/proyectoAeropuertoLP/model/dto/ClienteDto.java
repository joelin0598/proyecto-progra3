package programacion3.proyectoAeropuertoLP.model.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ClienteDto {

    @NotBlank
    @NotEmpty
    @Size(max = 15, message = "El campo debe tener como máximo {max} caracteres")
    private String pasaporte;

    @NotBlank
    @NotEmpty
    @Size(max = 50, message = "El campo debe tener como máximo {max} caracteres")
    private String nombres;

    @NotBlank
    @NotEmpty
    @Size(max = 50, message = "El campo debe tener como máximo {max} caracteres")
    private String apellidos;

    @NotBlank
    @NotEmpty
    private String fechaNacimiento;

    @NotBlank
    @NotEmpty
    private String nation;

    /*@NotBlank
    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;*/

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

    /*@NotBlank
    @NotEmpty
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$", message = "El formato de la contraseña no es válido")
    private String password;*/
    
}
