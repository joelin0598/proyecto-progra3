package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.RegisterRequest;

public interface AuthService {

    AuthResponse register( RegisterRequest request );

    AuthResponse authenticate(AuthenticationRequest request);
}