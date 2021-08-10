package edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.entities.Celular;
import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.servicios.CelService;


@RestController
@RequestMapping("/api/celular")
public class CelApiRest {

	@Autowired
	private CelService service; 
	
	@GetMapping
	public ResponseEntity<List<Celular>> listAll(){
		List<Celular> listaCelulares = service.findAll();
		if(listaCelulares.isEmpty()) {
			return new ResponseEntity<List<Celular>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Celular>>(listaCelulares, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Celular> getCel(@PathVariable("id") long id) {
        System.out.println("Fetching cel with id " + id);
        Celular cel = service.findById(id);
        if (cel == null) {
            System.out.println("Cel with id " + id + " not found");
            return new ResponseEntity<Celular>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Celular>(cel, HttpStatus.OK);
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createCel(@RequestBody Celular cel){
		System.out.println("Creating phone " + cel.getModelo());
		
		if (service.isCelExist(cel)) {
            System.out.println("A Phone with name " + cel.getModelo() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
		service.saveCel(cel);
		 return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Celular> updateCel(@PathVariable("id") int id,
			@RequestBody Celular celular){
		 System.out.println("Updating celular " + id);
		 Celular celularbd = service.findById(id);
		 if(celularbd == null) {
			 System.out.println("celular with id " + id + " not found");
			 return new ResponseEntity<Celular>(HttpStatus.NOT_FOUND);
		 }
		 celularbd.setAndroid( celular.getAndroid() );
		 celularbd.setMarca( celular.getMarca() );
		 celularbd.setTamaño( celular.getTamaño() );
		 celularbd.setModelo( celular.getModelo() );
		 celularbd.setPrecio( celular.getPrecio() );
		 celularbd.setMarca( celular.getMarca() );
		 celularbd.setGb_en_ram( celular.getGb_en_ram() );
		 celularbd.setProcesador( celular.getProcesador() );
		 celularbd.setAlmacenamiento_interno( celular.getAlmacenamiento_interno() );
		 celularbd.setCamara( celular.getCamara() );
		 celularbd.setBateria( celular.getBateria() );
		 
		 service.updateCel(celularbd);
		 return new ResponseEntity<Celular>(celularbd, HttpStatus.OK );
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCel(@PathVariable("id") int id){
		System.out.println("Fetching & Deleting cel with id " + id);
		Celular celular = service.findById(id);
		if(celular == null) {
			 System.out.println("Unable to delete. cel with id " + id + " not found");
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // 404
		}
		service.deleteCelById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204 http
	}
}
