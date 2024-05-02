package programacion3.proyectoAeropuertoLP.service.impl;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public UsuarioAerolinea save(UsuarioAerolinea usuarioAerolinea) {
        return usuarioAerolineaDao.save(usuarioAerolinea);
    }

    @Transactional
    @Override
    public UsuarioAerolinea update(UsuarioAerolinea usuarioAerolinea) {
        return usuarioAerolineaDao.save(usuarioAerolinea);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioAerolinea findById(Integer id) {
        return usuarioAerolineaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UsuarioAerolinea> findAll() {
        return (List<UsuarioAerolinea>) usuarioAerolineaDao.findAll();
    }

    @Transactional
    @Override
    public void delete(UsuarioAerolinea usuarioAerolinea) {
        usuarioAerolineaDao.delete(usuarioAerolinea);
    }
}
