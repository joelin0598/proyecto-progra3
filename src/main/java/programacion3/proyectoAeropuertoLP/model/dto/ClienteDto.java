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
    private String fechaNacimiento;

    @NotBlank
    @NotEmpty
    private String nation;

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
}
