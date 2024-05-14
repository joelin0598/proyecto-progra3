package programacion3.proyectoAeropuertoLP.service;

import org.apache.catalina.User;
import programacion3.proyectoAeropuertoLP.model.entity.Users;

import java.util.List;

public interface IUsers {
    Users save(Users user);
    Users update(Users user);
    Users findById(Integer id);
    List<Users> findAll();
    void delete(Users user);
}
