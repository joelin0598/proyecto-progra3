package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.VueloDto;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.service.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private IAvion avionService;

    @Autowired
    private CrudServiceProcessingController<Aerolinea, Integer> aerolineaService;

    @Autowired
    private IVuelo vueloService;

    @Autowired
    private CrudServiceProcessingController<Aeropuerto,Integer> aeropuertoService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{aerolineaId}/avionesActivos")
    public ResponseEntity<List<Avion>> listarAvionesActivos(@PathVariable Integer aerolineaId) {
        Aerolinea aerolinea = aerolineaService.findById(aerolineaId);
        List<Avion> avionesActivos = avionService.findByAerolineaId(aerolinea)
                .stream()
                .filter(Avion::isEstado)
                .toList();

        if (avionesActivos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        } else {
            return ResponseEntity.ok(avionesActivos);
        }
    }

    @PostMapping("post/fly")
    public ResponseEntity<?> crearVuelo(@Valid @RequestBody VueloDto vueloDto){
        Vuelo vuelo = new Vuelo();

        LocalDateTime fechaActual = LocalDateTime.now();

        if (vueloDto.getFechaHoraSalida().isEqual(vueloDto.getFechaHoraLlegada()) ||
                vueloDto.getFechaHoraSalida().isBefore(fechaActual) ||
                vueloDto.getFechaHoraLlegada().isBefore(fechaActual)) {
            return ResponseEntity.badRequest().body("Las fechas de salida y llegada deben ser posteriores a la fecha actual");
        }

        vuelo.setAerolineaId(aerolineaService.findById(vueloDto.getAerolineaId()));
        vuelo.setAvionId(avionService.findById(vueloDto.getAvionId()));
        vuelo.setAeropuertoSalidaId(aeropuertoService.findById(vueloDto.getAeropuertoSalidaId()));
        vuelo.setAeropuertoLlegadaId(aeropuertoService.findById(vueloDto.getAeropuertoLlegadaId()));
        vuelo.setAsientosDisponibles(vueloDto.getAsientosDisponibles());
        vuelo.setFechaHoraSalida(vueloDto.getFechaHoraSalida());
        vuelo.setFechaHoraLlegada(vueloDto.getFechaHoraLlegada());
        vuelo.setPrecioClaseEconomica(vueloDto.getPrecioClaseEconomica());
        vuelo.setPrecioClaseEjecutiva(vueloDto.getPrecioClaseEjecutiva());

        Vuelo nuevoVuelo = vueloService.save(vuelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVuelo);
    }

    @GetMapping("get/fly/{id}")
    public ResponseEntity<?> consultarVuelo(@PathVariable Integer id) {
        Vuelo vuelo = vueloService.findById(id);
        if (vuelo != null) {
            return ResponseEntity.ok(vuelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get/flyAll")
    public ResponseEntity<List<Vuelo>> listarVuelos() {
        List<Vuelo> vuelos = vueloService.findAll();
        if (!vuelos.isEmpty()) {
            return ResponseEntity.ok(vuelos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("get/listPlanes")
    public ResponseEntity<List<Avion>> listarAviones(){
        List<Avion> aviones = avionService.findAll();
        if (!aviones.isEmpty()) {
            return ResponseEntity.ok(aviones);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("get/listAirlines")
    public ResponseEntity<List<Aerolinea>>listarAerolineas(){
        List<Aerolinea> aerolineas = aerolineaService.findAll();
        if (!aerolineas.isEmpty()) {
            return ResponseEntity.ok(aerolineas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("get/listAirports")
    public ResponseEntity <List<Aeropuerto>> listarAeropuertos(){
        List<Aeropuerto> aeropuertos = aeropuertoService.findAll();
        if (!aeropuertos.isEmpty()) {
            return ResponseEntity.ok(aeropuertos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("get/Airline/{nombre}")
    public Aerolinea buscarAerolineaPorNombre(@PathVariable String nombre) {
        return aerolineaService.findByNombre(nombre);
    }

    @GetMapping("get/Airport/{nombre}")
    public Aeropuerto buscarAeropuertoPorNombre(@PathVariable String nombre) {
        return aeropuertoService.findByNombre(nombre);
    }
}
