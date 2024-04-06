package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.UsuarioAerolineaDao;
import programacion3.proyectoAeropuertoLP.model.dao.UsuarioDao;
import programacion3.proyectoAeropuertoLP.model.entity.Usuario;
import programacion3.proyectoAeropuertoLP.model.entity.UsuarioAerolinea;
import programacion3.proyectoAeropuertoLP.service.IUsuario;
import programacion3.proyectoAeropuertoLP.service.IUsuarioAerolinea;

import java.util.List;

@Service
public class UsuarioAerolineaImpl implements IUsuarioAerolinea {
    @Autowired
    private UsuarioAerolineaDao usuarioAerolineaDao;

    @Override
    public UsuarioAerolinea save(UsuarioAerolinea usuarioAerolinea) {
        return usuarioAerolineaDao.save(usuarioAerolinea);
    }

    @Override
    public UsuarioAerolinea findById(Integer id) {
        return usuarioAerolineaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(UsuarioAerolinea usuarioAerolinea) {
        usuarioAerolineaDao.delete(usuarioAerolinea);
    }

    @Override
    public List<UsuarioAerolinea> findAll() {
        return usuarioAerolineaDao.findAll();
    }
}
