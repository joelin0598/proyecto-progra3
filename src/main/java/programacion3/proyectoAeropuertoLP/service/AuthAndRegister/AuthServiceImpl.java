package programacion3.proyectoAeropuertoLP.service.AuthAndRegister;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.UserRepository;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.RegisterRequest;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.*;
import programacion3.proyectoAeropuertoLP.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request)  {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }
}
