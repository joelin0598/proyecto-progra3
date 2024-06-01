package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.exception.AvionesActiveException;
import programacion3.proyectoAeropuertoLP.model.dto.VueloDto;
import programacion3.proyectoAeropuertoLP.model.entity.*;
import programacion3.proyectoAeropuertoLP.service.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAvion avionService;

    @Autowired
    private IVuelo vueloService;

    @Autowired
    private CrudServiceProcessingController<Tripulacion, Integer> tripulacionService;

    @Autowired
    private CrudServiceProcessingController<Aerolinea, Integer> aerolineaService;

    @Autowired
    private CrudServiceProcessingController<Aeropuerto,Integer> aeropuertoService;

    @Autowired
    private CrudServiceProcessingController<Estado, Integer> estadoService;


    @GetMapping("/planesActiveByAirlineId/{aerolineaId}")
    public ResponseEntity<?> listarAvionesActivos(@PathVariable Integer aerolineaId) {
        try {
            Aerolinea aerolinea = aerolineaService.findById(aerolineaId);
            if (aerolinea == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aerolinea no encontrada");
            }

            Estado estadoActivo = estadoService.findById(1);
            if (estadoActivo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Estado activo no encontrado");
            }
            List<Avion> avionesActivos = avionService.findByAerolineaAndEstado(aerolinea, estadoActivo);
            if (avionesActivos.isEmpty()) {
                throw new AvionesActiveException("No hay aviones activos disponibles para esta aerolínea.");
            } else {
                return ResponseEntity.ok(avionesActivos);
            }
        } catch (AvionesActiveException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @PostMapping("/post/fly")
    public ResponseEntity<?> crearVuelo(@Valid @RequestBody VueloDto vueloDto) {
        try {
            Vuelo vuelo = new Vuelo();

            LocalDateTime fechaActual = LocalDateTime.now();

            if (vueloDto.getFechaHoraSalida().isEqual(vueloDto.getFechaHoraLlegada()) ||
                    vueloDto.getFechaHoraSalida().isBefore(fechaActual) ||
                    vueloDto.getFechaHoraLlegada().isBefore(fechaActual)) {
                return ResponseEntity.badRequest().body("Las fechas de salida y llegada deben ser posteriores a la fecha actual");
            }

            if(vueloDto.getAeropuertoSalidaId().equals(vueloDto.getAeropuertoLlegadaId())){
                return ResponseEntity.badRequest().body("El aeropuerto de llegada no puede ser igual al de salida");
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

            Avion avion = avionService.findById(vueloDto.getAvionId());
            if (avion != null && avion.getTripulacionId() != null){
                Tripulacion tripulacion = avion.getTripulacionId();
                vuelo.setTripulacion(tripulacion);
            }

            Vuelo nuevoVuelo = vueloService.save(vuelo);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVuelo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
            }
    }

    @GetMapping("/get/tripulacionByPlaneId/{avionId}")
    public ResponseEntity<?> listarTripulacionPorAvionId(@PathVariable Integer avionId) {
        try {
            Avion avion = avionService.findById(avionId);
            if (avion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avión no encontrado");
            }
            Tripulacion tripulacion = avion.getTripulacionId();
            if (tripulacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tripulación no encontrada para este avión");
            }
            List<Empleados> empleados = tripulacion.getEmpleadosList();
            if (empleados.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay empleados asignados a esta tripulación");
            }
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }


    @GetMapping("/get/tripulacionById/{id}")
    public ResponseEntity<?> consultarTripulacionPorId(@PathVariable Integer id) {
        try {
            Tripulacion tripulacion = tripulacionService.findById(id);
            if (tripulacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tripulación no encontrada");
            }
            return ResponseEntity.ok(tripulacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listTripulacionAll")
    public ResponseEntity<?> listarTodasLasTripulaciones() {
        try {
            List<Tripulacion> tripulaciones = tripulacionService.findAll();
            if (tripulaciones.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontraron tripulaciones");
            }
            return ResponseEntity.ok(tripulaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/flyById/{id}")
    public ResponseEntity<?> consultarVuelo(@PathVariable Integer id) {
        try {
            Vuelo vuelo = vueloService.findById(id);
            if (vuelo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo no encontrado");
            }
                return ResponseEntity.ok(vuelo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listFlightsAll")
    public ResponseEntity<?> listarTodosLosVuelos() {
        try {
            List<Vuelo> vuelos = vueloService.findAll();
            if (vuelos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron vuelos");
            }
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/planeById/{id}")
    public ResponseEntity<?> consultarAvionPorId(@PathVariable Integer id) {
        try {
            Avion avion = avionService.findById(id);
            if (avion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avión no encontrado");
            }
            return ResponseEntity.ok(avion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listPlanesAll")
    public ResponseEntity<?> listarTodosLosAviones() {
        try {
            List<Avion> aviones = avionService.findAll();
            if (aviones.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron aviones");
            }
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/airlineById/{id}")
    public ResponseEntity<?> consultarAerolineaPorId(@PathVariable Integer id) {
        try {
            Aerolinea aerolinea = aerolineaService.findById(id);
            if (aerolinea == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aerolínea no encontrada");
            }
            return ResponseEntity.ok(aerolinea);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listAirlinesAll")
    public ResponseEntity<?> listarTodasLasAerolineas() {
        try {
            List<Aerolinea> aerolineas = aerolineaService.findAll();
            if (aerolineas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron aerolíneas");
            }
            return ResponseEntity.ok(aerolineas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/airlineByName/{nombre}")
    public ResponseEntity<?> buscarAerolineaPorNombre(@PathVariable String nombre) {
        try {
            Aerolinea aerolinea = aerolineaService.findByNombre(nombre);
            if (aerolinea == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aerolínea no encontrada");
            }
            return ResponseEntity.ok(aerolinea);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/airportById/{id}")
    public ResponseEntity<?> consultarAeropuertoPorId(@PathVariable Integer id) {
        try {
            Aeropuerto aeropuerto = aeropuertoService.findById(id);
            if (aeropuerto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aeropuerto no encontrado");
            }
            return ResponseEntity.ok(aeropuerto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listAirportsAll")
    public ResponseEntity<?> listarTodosLosAeropuertos() {
        try {
            List<Aeropuerto> aeropuertos = aeropuertoService.findAll();
            if (aeropuertos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron aeropuertos");
            }
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/airportByName/{nombre}")
    public ResponseEntity<?> buscarAeropuertoPorNombre(@PathVariable String nombre) {
        try {
            Aeropuerto aeropuerto = aeropuertoService.findByNombre(nombre);
            if (aeropuerto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aeropuerto no encontrado");
            }
            return ResponseEntity.ok(aeropuerto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }
}
