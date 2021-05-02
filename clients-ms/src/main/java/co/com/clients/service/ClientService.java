package co.com.clients.service;

import org.springframework.http.ResponseEntity;

import co.com.clients.model.entity.ModelClientEntity;
public interface ClientService {

	public ResponseEntity<Object> findAll();
	
	public ResponseEntity<Object> save(ModelClientEntity request);
	
	public ModelClientEntity findById(Long id);
}
