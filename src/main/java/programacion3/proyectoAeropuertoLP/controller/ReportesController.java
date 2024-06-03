package programacion3.proyectoAeropuertoLP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;
import programacion3.proyectoAeropuertoLP.model.entity.Aeropuerto;
import programacion3.proyectoAeropuertoLP.model.entity.Avion;
import programacion3.proyectoAeropuertoLP.model.entity.Vuelo;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;
import programacion3.proyectoAeropuertoLP.service.IAvion;
import programacion3.proyectoAeropuertoLP.service.IDestino;
import programacion3.proyectoAeropuertoLP.service.IVuelo;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportesController {

    @Autowired
    private IDestino destinoServie;

    @Autowired
    private IAvion avionService;

    @Autowired
    private IVuelo vueloService;

    @Autowired
    private CrudServiceProcessingController<Aerolinea, Integer> aerolineaService;

    @GetMapping("/get/listDestinationsByAirlineId/{aerolineaId}")/*Caso de Uso Reporte Destinos Autorizado Aerolinea*/
    public ResponseEntity<?> listarAeropuertosPorAerolinea(@PathVariable Integer aerolineaId) {
        try {
            Aerolinea aerolinea = aerolineaService.findById(aerolineaId);
            if (aerolinea == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aerolínea no encontrada");
            }
            List<Aeropuerto> aeropuertos = destinoServie.findAeropuertosByAerolinea(aerolinea);
            if (aeropuertos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La aerolínea consultada no tiene destinos autorizados");
            }
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listPlanesByAirlineId/{aerolineaId}")/*Caso de Uso Reporte de Aviones por Aerolinea */
    public ResponseEntity<?> listarAvionesPorAerolinea(@PathVariable Integer aerolineaId) {
        try {
            List<Avion> aviones = avionService.findByAerolineaId(aerolineaId);
            if (aviones.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron aviones para esta aerolínea");
            }
            return ResponseEntity.ok(aviones);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema");
        }
    }

    @GetMapping("/get/listFlightsAll")/*Caso de Uso Consultar Vuelo*/
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

    @GetMapping("/get/flyById/{id}")/*Caso de Uso Consultar Vuelo*/
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
}

