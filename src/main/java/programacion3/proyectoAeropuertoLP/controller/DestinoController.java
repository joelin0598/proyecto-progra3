package programacion3.proyectoAeropuertoLP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.DestinoDto;
import programacion3.proyectoAeropuertoLP.model.entity.Destino;
import programacion3.proyectoAeropuertoLP.model.payload.MensajeResponse;
import programacion3.proyectoAeropuertoLP.service.IDestino;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "*")
public class DestinoController {
    @Autowired
    private IDestino destinoService;


    @GetMapping ("/destinos")
    public ResponseEntity<?> buscarTodos(){
        List<Destino> destinos = destinoService.findAll();
        List<DestinoDto> destinoDtos = destinos.stream()
                .map(destino -> DestinoDto.builder()
                        .id(destino.getId())
                        //.aerolineaId(destino.getAerolineaId())
                        //.aeropuertoId(destino.getAeropuertoId())

                        .descripcion(destino.getDescripcion())
                        .fechaCreacion(destino.getFechaCreacion())
                        .fechaModificacion(destino.getFechaModificacion())
                        .creadoPor(destino.getCreadoPor())
                        .modificadoPor(destino.getModificadoPor())
                        .build())
                .collect(Collectors.toList());
                return new ResponseEntity<>(destinoDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        Destino destino = destinoService.findById(id);
        if (destino == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El Destino con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
        DestinoDto destinoDto = DestinoDto.builder()
                .id(destino.getId())
                //.aerolineaId(destino.getAerolineaId())
                //.aeropuertoId(destino.getAeropuertoId())
                .descripcion(destino.getDescripcion())
                .fechaCreacion(destino.getFechaCreacion())
                .fechaModificacion(destino.getFechaModificacion())
                .creadoPor(destino.getCreadoPor())
                .modificadoPor(destino.getModificadoPor())
                .build();
            return new ResponseEntity<>(destinoDto, HttpStatus.OK);
    }

    @PostMapping("destino/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearDestino(@RequestBody DestinoDto destinoDto){
        Destino destino = new Destino();

        destino.setId(destinoDto.getId());
        //destino.setAerolineaId(destinoDto.getAerolineaId());
        //destino.setAeropuertoId(destinoDto.getAeropuertoId());
        destino.setDescripcion(destinoDto.getDescripcion());

        // Convierte LocalDateTime a Timestamp
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        destino.setFechaCreacion(timestamp);

        destino.setCreadoPor(destinoDto.getCreadoPor());

        Destino destinoResponse = destinoService.save(destino);
        return  ResponseEntity.ok(destinoResponse);
    }

    @PutMapping("/destino/{id}")
    public ResponseEntity<?> actualizarDestino(@PathVariable Integer id, @RequestBody DestinoDto destinoDto) {
        Destino destinoExistente = destinoService.findById(id);
        if (destinoExistente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El destino con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }

        // Actualizar los campos del destino existente con los datos proporcionados
        destinoExistente.setDescripcion(destinoDto.getDescripcion());
        //destinoExistente.setAerolineaId(destinoDto.getAerolineaId());
        //destinoExistente.setAeropuertoId(destinoDto.getAeropuertoId());
        destinoExistente.setCreadoPor(destinoDto.getCreadoPor());

        // Convierte LocalDateTime a Timestamp
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        destinoExistente.setFechaModificacion(timestamp);

        destinoExistente.setModificadoPor(destinoDto.getModificadoPor());

        // Guardar el destino actualizado
        Destino destinoActualizado = destinoService.save(destinoExistente);

        return ResponseEntity.ok(destinoActualizado);
    }


    @DeleteMapping("/destino/{id}")
    public ResponseEntity<?> eliminarDestino(@PathVariable Integer id) {
        Destino destino = destinoService.findById(id);
        if (destino == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El destino con el ID " + id + " no existe.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
        destinoService.delete(destino);
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Destino eliminado con éxito.")
                        .object(null)
                        .build(),
                HttpStatus.NO_CONTENT
        );
    }


}
