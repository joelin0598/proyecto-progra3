package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.UserEntity;

import java.util.List;

public interface IUsers {
    UserEntity save(UserEntity user);
    UserEntity update(UserEntity user);
    UserEntity findById(Integer id);
    List<UserEntity> findAll();
    void delete(UserEntity user);
}
