package edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.entities.Celular;

public interface CelularRepository extends CrudRepository<Celular, Integer> {
	@Query("SELECT cel FROM Celular cel WHERE cel.modelo = ?1  ")
	public  Celular findByModelo(String modelo);
}
