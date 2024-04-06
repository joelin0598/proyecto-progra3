package programacion3.proyectoAeropuertoLP.service;

import programacion3.proyectoAeropuertoLP.model.entity.Boleto;

import java.util.List;

public interface IBoleto {
    Boleto save(Boleto boleto);
    Boleto update(Boleto boleto);
    Boleto findById(Integer id);
    void delte(Boleto boleto);
    List<Boleto> findAll();
}
