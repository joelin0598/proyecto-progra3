package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Usuario;

import java.util.List;

public interface IUsuario {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    Usuario findById(Integer id);
    List<Usuario> findAll();
    void delete(Usuario usuario);
}
