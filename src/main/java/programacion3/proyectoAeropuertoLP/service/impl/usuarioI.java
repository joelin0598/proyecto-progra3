package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;
import programacion3.proyectoAeropuertoLP.model.dao.UsuarioDao;
import programacion3.proyectoAeropuertoLP.service.IUsuario;

import java.util.List;

@Service
public class usuarioI implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
}
