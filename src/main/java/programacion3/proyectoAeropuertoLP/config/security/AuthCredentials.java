package programacion3.proyectoAeropuertoLP.config.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String password;
    private String email;
}
