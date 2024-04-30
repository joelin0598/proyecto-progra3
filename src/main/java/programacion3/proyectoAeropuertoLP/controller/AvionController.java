package programacion3.proyectoAeropuertoLP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.AvionDto;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.service.IAvion;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AvionController {

    @Autowired
    private IAvion avionServie;
    /*
    @GetMapping("/activos/{idAerolinea}")
    public ResponseEntity<List<AvionDto>> obtenerListaAviones(@PathVariable Integer idAerolinea) {
        List<AvionDto> aviones = avionServie.obtenerListaAviones(idAerolinea);
        return ResponseEntity.ok(aviones);
    }
    */
}
