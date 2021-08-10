package edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.entities.Celular;
import edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.repositorios.CelularRepository;

@Service
public class CelServiceImp implements CelService{
	@Autowired
	private CelularRepository celDao;

	//buscar por id
	@Override
	public Celular findById(long id) {
		return celDao.findById((int) id)
				.orElse(null);
	
	}

	//buscar por modelo
	@Override
	public Celular findByModelo(String modelo) {
		return celDao.findByModelo(modelo);
	
	}

	//buscar todos
	@Override
	public List<Celular> findAll() {
		List<Celular> lista = new ArrayList<>();
		celDao.findAll()
			.forEach( lista::add );
		return lista;
	}

	//si un celular existe
	@Override
	public boolean isCelExist(Celular cel) {
		return celDao.existsById(cel.getId() );
	}

	//guardar
	@Override @Transactional
	public void saveCel(Celular cel) {
		celDao.save(cel);
		
	}

	//actualizar 
	@Override @Transactional
	public void updateCel(Celular cel) {
		Celular celdb = celDao.findById(cel.getId() ).orElse(null);
		if(celdb != null) {
			celdb.setAndroid( cel.getAndroid() );//
			celdb.setMarca( cel.getMarca() );//
			celdb.setModelo( cel.getModelo() );		//	
			celdb.setTamaño( cel.getTamaño() );//
			celdb.setPrecio( cel.getPrecio() );//
			celdb.setGb_en_ram( cel.getGb_en_ram() );
			celdb.setProcesador( cel.getProcesador() );
			celdb.setAlmacenamiento_interno( cel.getAlmacenamiento_interno() );
			celdb.setCamara( cel.getCamara() );
			celdb.setBateria( cel.getBateria() );
			
			celDao.save(celdb);
		}
	}

	@Override @Transactional
	public void deleteCelById(long id) {
		celDao.deleteById( (int) id );	
	}
}
