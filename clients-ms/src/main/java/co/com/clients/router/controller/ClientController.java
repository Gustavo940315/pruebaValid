package co.com.clients.router.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.clients.manager.ClientManager;
import co.com.clients.model.request.ClientSaveRequestDTO;

import static co.com.clients.router.RouterConsts.*;

@RestController
@RequestMapping(INITIAL_PATH)
public class ClientController {

	@Autowired
	private ClientManager clientManager;
	
	@PostMapping(POST_MAPPING_SAVE_CLIENT)
	public ResponseEntity<Object> clientSave(@RequestBody ClientSaveRequestDTO request) {
		return clientManager.save(request);
	}
	
	@GetMapping(GET_MAPPING_FINDALL_CLIENT)
	public ResponseEntity<Object> clientFindAll() {
		return clientManager.findAll();
	}
	
	@PostMapping(POST_MAPPING_UPDATE_CLIENT)
	public ResponseEntity<Object> clientUpdateClient(@RequestBody ClientSaveRequestDTO request) {
		return clientManager.findById(request);
	}
	
}
