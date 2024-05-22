package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request );
    AuthResponse authenticate(AuthenticationRequest request);
}
