package programacion3.proyectoAeropuertoLP.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programacion3.proyectoAeropuertoLP.model.dto.ClienteDto;
import programacion3.proyectoAeropuertoLP.model.entity.Cliente;
import programacion3.proyectoAeropuertoLP.service.ICliente;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private ICliente clienteService;

    @Autowired
    private ModelMapper modelMapper ;
    @PostMapping("post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearPasajeros(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente = modelMapper.map(clienteDto, Cliente.class);
        Cliente nuevoCliente = clienteService.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @GetMapping("get/pasajeros{id}")
    public ResponseEntity<Cliente> consultarPasajeroId(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Cliente>> consultarPasajeros() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }


}


