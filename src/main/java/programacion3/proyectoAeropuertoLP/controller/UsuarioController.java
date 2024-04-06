package programacion3.proyectoAeropuertoLP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.UsuarioDto;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;
import programacion3.proyectoAeropuertoLP.service.IUsuario;
import programacion3.proyectoAeropuertoLP.model.payload.MensajeResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El usuario con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .tipo(usuario.getTipo())
                .build();
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> buscarTodos() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDto> usuarioDtos = usuarios.stream()
                .map(usuario -> UsuarioDto.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .tipo(usuario.getTipo())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping("Usuario/Crear")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearUsur(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();

        usuario.setId(usuarioDto.getId());
        usuario.setTipo(usuarioDto.getTipo());
        usuario.setNombre(usuarioDto.getNombre());

        Usuario usuarioResponse = usuarioService.save(usuario);

        return ResponseEntity.ok(usuarioResponse);
    }
    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioService.findById(id);
        if (usuarioExistente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El usuario con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }

        // Actualizando los campos del usuario existente con los datos proporcionados
        usuarioExistente.setNombre(usuarioDto.getNombre());
        usuarioExistente.setTipo(usuarioDto.getTipo());
        // Agrega aquí cualquier otro campo que desees actualizar

        // Guardar el usuario actualizado
        Usuario usuarioActualizado = usuarioService.save(usuarioExistente);

        return ResponseEntity.ok(usuarioActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El usuario con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
        usuarioService.delete(usuario);
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Usuario eliminado con éxito.")
                        .object(null)
                        .build(),
                HttpStatus.NO_CONTENT
        );
    }
}
