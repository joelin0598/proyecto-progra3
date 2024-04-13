package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import programacion3.proyectoAeropuertoLP.exception.FormatoContraseñaInvalidoException;
import programacion3.proyectoAeropuertoLP.exception.PasaporteExistenteException;
import programacion3.proyectoAeropuertoLP.model.dao.PasajeroDao;
import programacion3.proyectoAeropuertoLP.model.entity.Pasajero;
import programacion3.proyectoAeropuertoLP.service.IPasajero;

import java.util.List;

@Service
public class PasajeroImpl implements IPasajero {
    @Autowired
    private PasajeroDao pasajeroDao;

    @Override
    public Pasajero save(Pasajero pasajero) {
        if (pasajeroDao.existsByPasaporte(pasajero.getPasaporte())) {
            throw new PasaporteExistenteException("El número de pasaporte ya está en uso");
        }
        if (!pasajero.getPassword().matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$")) {
            throw new FormatoContraseñaInvalidoException("El formato de la contraseña no es válido");
        }
        return pasajeroDao.save(pasajero);
    }

    @Transactional
    @Override
    public Pasajero update(Pasajero pasajero) {
        return pasajeroDao.save(pasajero);
    }

    @Transactional(readOnly = true)
    @Override
    public Pasajero findById(Integer id) {
        return pasajeroDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Pasajero pasajero) {
        pasajeroDao.delete(pasajero);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pasajero> findAll() {
        return (List<Pasajero>) pasajeroDao.findAll();
    }

    @Transactional
    @Override
    public boolean existsByPasaporte(String pasaporte) {
        return pasajeroDao.existsByPasaporte(pasaporte);
    }

    /*
    @Transactional
    @Override
    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$");
    }
    */

}
