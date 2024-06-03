package programacion3.proyectoAeropuertoLP.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CrudServiceProcessingController<T,ID>{
    T save(T entity);
    T update(T entity);
    T findById(ID id);
    List<T> findAll();
    T findByNombre(String nombre);
    void delete(T entity);
}