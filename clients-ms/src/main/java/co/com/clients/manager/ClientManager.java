package co.com.clients.manager;

import org.springframework.http.ResponseEntity;

import co.com.clients.model.request.ClientSaveRequestDTO;

public interface ClientManager {

	public ResponseEntity<Object> findAll();
	
	public ResponseEntity<Object> save(ClientSaveRequestDTO request);
	
	public ResponseEntity<Object> findById(ClientSaveRequestDTO request);
}
