package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.UsersDao;
import programacion3.proyectoAeropuertoLP.model.entity.Users;
import programacion3.proyectoAeropuertoLP.service.IUsers;

import java.util.List;

@Service
public class UsersImpl implements IUsers {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users save(Users user) {
        return usersDao.save(user);
    }

    @Override
    public Users update(Users user) {
        return usersDao.save(user);
    }

    @Override
    public Users findById(Integer id) {
        return usersDao.findById(id).orElse(null);
    }

    @Override
    public List<Users> findAll() {
        return (List<Users>) usersDao.findAll();
    }

    @Override
    public void delete(Users user) {
    }
}
