package programacion3.proyectoAeropuertoLP.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.exception.CustomAuthenticationException;
import programacion3.proyectoAeropuertoLP.exception.DuplicateEmailException;
import programacion3.proyectoAeropuertoLP.exception.InvalidPasswordFormatException;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.ErrorResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.RegisterRequest;
import programacion3.proyectoAeropuertoLP.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            return ResponseEntity.ok(authService.authenticate(request));
        } catch (CustomAuthenticationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorResponse.builder().errorMessage(e.getMessage()).build());
        }
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleCustomAuthenticationException(CustomAuthenticationException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorResponse.builder().errorMessage(e.getMessage()).build());
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(InvalidPasswordFormatException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPasswordFormatException(InvalidPasswordFormatException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
    }
}