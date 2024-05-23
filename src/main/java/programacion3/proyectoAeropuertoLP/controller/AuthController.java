package programacion3.proyectoAeropuertoLP.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthResponse;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.AuthenticationRequest;
import programacion3.proyectoAeropuertoLP.model.dto.AuthAndRegister.RegisterRequest;
import programacion3.proyectoAeropuertoLP.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}