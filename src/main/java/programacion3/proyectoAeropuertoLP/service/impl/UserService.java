package programacion3.proyectoAeropuertoLP.service.impl;

import org.springframework.stereotype.Service;
import programacion3.proyectoAeropuertoLP.model.dao.UsersDao;
import programacion3.proyectoAeropuertoLP.model.entity.UserEntity;
import programacion3.proyectoAeropuertoLP.service.CrudServiceProcessingController;

import java.util.List;

@Service
public class UserService implements CrudServiceProcessingController<UserEntity,Integer> {

    private final UsersDao usersDao;

    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }


    @Override
    public UserEntity save(UserEntity entity) {
        return usersDao.save(entity);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        return usersDao.save(entity);
    }

    @Override
    public UserEntity findById(Integer integer) {
        return usersDao.findById(integer).orElse(null);
    }

    @Override
    public void delete(UserEntity entity) {
        usersDao.delete(entity);
    }

    @Override
    public List<UserEntity> findAll() {
        return usersDao.findAll();
    }

    public UserEntity findByEmail(String email){
        return usersDao.findByEmail(email);
    }
}
