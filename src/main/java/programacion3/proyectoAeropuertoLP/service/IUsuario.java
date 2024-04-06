package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Usuario;

import java.util.List;

public interface IUsuario {
    Usuario save(Usuario usuario);
    Usuario findById(Integer id);
    void delete(Usuario usuario);
    List<Usuario> findAll();
}
