package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.exception.FormatoContraseñaInvalidoException;
import programacion3.proyectoAeropuertoLP.exception.PasaporteExistenteException;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;
import programacion3.proyectoAeropuertoLP.model.dao.UsuarioDao;
import programacion3.proyectoAeropuertoLP.service.IUsuario;

import java.util.List;

@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional
    @Override
    public Usuario save(Usuario usuario){
        if (usuarioDao.existsByPasaporte(usuario.getPasaporte())) {
            throw new PasaporteExistenteException("El número de pasaporte ya está en uso");
        }
        if (!usuario.getPassword().matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$")) {
            throw new FormatoContraseñaInvalidoException("El formato de la contraseña no es válido");
        }
        return usuarioDao.save(usuario);
    }

    @Transactional
    @Override
    public Usuario update(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public boolean existsByPasaporte(String pasaporte) {
        return usuarioDao.existsByPasaporte(pasaporte);
    }
}
