package co.com.clients.router.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.clients.manager.ClientManager;
import co.com.clients.model.request.ClientSaveRequestDTO;

import static co.com.clients.router.RouterConsts.*;

@CrossOrigin(CROSS_ORIGIN)
@RestController
@RequestMapping(INITIAL_PATH)
public class ClientController {

	@Autowired
	private ClientManager clientManager;
	
	@PostMapping(POST_MAPPING_SAVE_CLIENT)
	public ResponseEntity<Object> clientSave(@RequestBody ClientSaveRequestDTO request) {
		return new ResponseEntity<>(clientManager.save(request).getBody(), HttpStatus.OK);
	}
	
	@GetMapping(GET_MAPPING_FINDALL_CLIENT)
	public ResponseEntity<Object> clientFindAll() {
		return new ResponseEntity<>(clientManager.findAll().getBody(), HttpStatus.OK);
	}
	
	@PutMapping(PUT_MAPPING_UPDATE_CLIENT)
	public ResponseEntity<Object> clientUpdateClient(@RequestBody ClientSaveRequestDTO request) {
		return new ResponseEntity<>(clientManager.updateById(request).getBody(), HttpStatus.OK);
	}
	
}
