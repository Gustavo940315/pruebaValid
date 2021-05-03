package co.com.clients.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.clients.model.entity.ModelClientEntity;
public interface ClientService {

	public List<ModelClientEntity> findAll();
	
	public ResponseEntity<Object> save(ModelClientEntity request);
	
	public ModelClientEntity findById(Long id);
}
