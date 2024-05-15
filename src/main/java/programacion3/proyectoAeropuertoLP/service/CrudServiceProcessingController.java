package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Aerolinea;

import java.util.List;

public interface CrudServiceProcessingController<T,ID> {
    T save(T entity);
    T update(T entity);
    T findById(ID id);
    void delete(T entity);
    List<T> findAll();
}
