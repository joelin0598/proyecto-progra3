package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.UsersDao;
import programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister.User;
import programacion3.proyectoAeropuertoLP.service.IUsers;

import java.util.List;

@Service
public class UsersImpl implements IUsers {

    @Autowired
    private UsersDao usersDao;

    @Override
    public User save(User user) {
        return usersDao.save(user);
    }

    @Override
    public User update(User user) {
        return usersDao.save(user);
    }

    @Override
    public User findById(Integer id) {
        return usersDao.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) usersDao.findAll();
    }

    @Override
    public void delete(User user) {
    }
}
