package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.UsuarioAerolinea;

import java.util.List;

public interface IUsuarioAerolinea {

    UsuarioAerolinea save(UsuarioAerolinea usuarioAerolinea);
    UsuarioAerolinea findById(Integer id);
    void delete(UsuarioAerolinea usuarioAerolinea);
    List<UsuarioAerolinea> findAll();
}
