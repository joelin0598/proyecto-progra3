package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.PasajeroDto;
import programacion3.proyectoAeropuertoLP.model.entity.Pasajero;
import programacion3.proyectoAeropuertoLP.service.IPasajero;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PasajeroController {

    @Autowired
    private IPasajero pasajeroService;

    @Autowired
    private ModelMapper modelMapper ;
    @PostMapping("post/pasajeros")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearPasajeros(@Valid @RequestBody PasajeroDto pasajeroDto) {
        Pasajero pasajero = new Pasajero();
        pasajero= modelMapper.map(pasajeroDto, Pasajero.class);
        /*
        pasajero.setPasaporte(pasajeroDto.getPasaporte());
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
        Pasajero pasajeroResponse = pasajeroService.save(pasajero);
        return ResponseEntity.ok(pasajeroResponse);
    }
}
