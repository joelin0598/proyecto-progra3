package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.UsuarioDto;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;
import programacion3.proyectoAeropuertoLP.service.IUsuario;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @Autowired
    private ModelMapper modelMapper ;
    @PostMapping("post/pasajeros")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearPasajeros(@Valid @RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario= modelMapper.map(usuarioDto, Usuario.class);

        /*pasajero.setPasaporte(pasajeroDto.getPasaporte());
        pasajero.setNombres(pasajeroDto.getNombres());
        pasajero.setApellidos(pasajeroDto.getApellidos());
        pasajero.setFechaNacimiento(pasajeroDto.getFechaNacimiento());
        pasajero.setNation(pasajeroDto.getNation());
        pasajero.setEmail(pasajeroDto.getEmail());
        pasajero.setCodigoAreaPais(pasajeroDto.getCodigoAreaPais());
        pasajero.setTel(pasajeroDto.getTel());
        pasajero.setTelEmergencias(pasajeroDto.getTelEmergencias());
        pasajero.setDireccion(pasajeroDto.getDireccion());
        pasajero.setPassword(pasajeroDto.getPassword());*/

        Usuario usuarioResponse = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioResponse);
    }

    @GetMapping("get/pasajeros{id}")
    public ResponseEntity<Usuario> consultarPasajeroId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("getAll/pasajeros")
    public ResponseEntity<List<Usuario>> consultarPasajeros() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
}


