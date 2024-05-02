package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.service.*;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    /*
    @Autowired
    private IVuelo vueloService;

    @PostMapping("post/vuelos")
    public ResponseEntity<?> crearVuelo(@Valid @RequestBody Vuelo vuelo){//Pendiente configurar DTO
        Integer aerolineaId = vuelo.getAerolineaId().getId();
        boolean aerolineaConAvionesActivos = vueloService.validarAerolineaConAvionesActivos(aerolineaId);// Verificar si la aerolínea tiene aviones con estado activo
        if(!aerolineaConAvionesActivos){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La aerolínea no tiene aviones con estado activo");
        }
        Vuelo nuevoVuelo = vueloService.save(vuelo);// Si la aerolínea tiene aviones con estado activo, proceder con la creación del vuelo
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVuelo);
    }
     */
}
