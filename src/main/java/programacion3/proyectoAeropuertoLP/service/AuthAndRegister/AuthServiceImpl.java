package programacion3.proyectoAeropuertoLP.service.AuthAndRegister;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.exception.CustomAuthenticationException;
import programacion3.proyectoAeropuertoLP.exception.DuplicateEmailException;
import programacion3.proyectoAeropuertoLP.exception.InvalidPasswordFormatException;
import programacion3.proyectoAeropuertoLP.model.dao.UserRepository;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.RegisterRequest;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.*;
import programacion3.proyectoAeropuertoLP.service.AuthService;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;//Interfaz propia de Spring Security
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$");

    private void validatePassword(String password) {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordFormatException(
                    "Formato de contraseña inválido: Mínimo de 9 caracteres, debe incluir al menos una letra mayúscula, un carácter especial y un número");
        }
    }

    @Override
    public AuthResponse register(RegisterRequest request) {//Método para generar el token después del registro del usuario.
        if (userRepository.findUserByEmail(request.getEmail()).isPresent()) {// Verificar si el correo electrónico ya existe
            throw new DuplicateEmailException("El correo electrónico ya está en uso");
        }
        validatePassword(request.getPassword());// Validar la contraseña
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))//Encriptación del password
                .role(Role.USER)//Por default se coloco USER = usuario normal, modificar lógica según requerimiento.
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);//Siempre a base de userDetails
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        try {
            var user = userRepository.findUserByEmail(request.getEmail())
                    .orElseThrow(() -> new CustomAuthenticationException("Usuario no registrado"));

            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );
            } catch (BadCredentialsException e) {
                throw new CustomAuthenticationException("Contraseña incorrecta");
            }

            var jwtToken = jwtService.generateToken(user);
            return AuthResponse.builder()
                    .token(jwtToken)
                    .build();
        } catch (UsernameNotFoundException e) {
            throw new CustomAuthenticationException("Usuario no registrado");
        }
    }
}
