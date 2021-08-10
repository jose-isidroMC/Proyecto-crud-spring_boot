package edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.servicios;

import java.util.List;

import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.entities.Celular;

public interface CelService {
	Celular findById(long id);
    Celular findByModelo(String modelo);
    List<Celular> findAll(); 
    boolean isCelExist(Celular cel);
    //CREAR 
    void saveCel(Celular cel);
     //Actualizar
    void updateCel(Celular cel);
    //Borrar
    void deleteCelById(long id);
}
