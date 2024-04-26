package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.VueloDto;
import programacion3.proyectoAeropuertoLP.model.entity.TripulacionVuelo;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.service.ITripulacion;
import programacion3.proyectoAeropuertoLP.service.ITripulacionVuelo;
import programacion3.proyectoAeropuertoLP.service.IVuelo;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private IVuelo vueloService;

    @Autowired
    private ITripulacionVuelo tripulacionVueloService;

    @Autowired
    private ITripulacion tripulacionService;

    @PostMapping("post/vuelos")
    public ResponseEntity<?> crearVuelos(@Valid @RequestBody VueloDto vueloDto) {
        Vuelo vuelo = new Vuelo();

        Vuelo vueloResponse = vueloService.save(vuelo);

        vueloDto.getTripulacionVueloList().forEach(tripulacionVueloDto -> {
            TripulacionVuelo tripulacionVuelo = new TripulacionVuelo();
            tripulacionVuelo.setTripulacionId(tripulacionService.findById(tripulacionVueloDto.getTripulacionId());
            tripulacionVuelo.setNumeroVueloId(vueloResponse);
            tripulacionVueloService.save(tripulacionVuelo);
        });
        return ResponseEntity.ok(vueloResponse);
    }

}
