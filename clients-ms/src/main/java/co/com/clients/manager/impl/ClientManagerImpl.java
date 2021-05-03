package co.com.clients.manager.impl;

import static co.com.clients.router.RouterConsts.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import co.com.clients.manager.ClientManager;
import co.com.clients.model.entity.ModelClientEntity;
import co.com.clients.model.error.ErrorDTO;
import co.com.clients.model.request.ClientSaveRequestDTO;
import co.com.clients.service.ClientService;

@Component
public class ClientManagerImpl implements ClientManager {

	@Autowired
	private ClientService clientService; 
	
	@Override
	public ResponseEntity<Object> findAll() {
		ErrorDTO errorResponse = new ErrorDTO();
		try {
			return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			errorResponse.setMensaje(EXCEPTION_FINDBYID_CLIENT);
			errorResponse.setStatus(INTERNAL_SERVER_ERROR_STATUS);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> save(ClientSaveRequestDTO request) {
		ModelClientEntity requestBD =  new ModelClientEntity();
		ErrorDTO errorResponse = new ErrorDTO();
		try {
			if(!request.getNombre().isEmpty() && ! request.getApellido().isEmpty()) {
				requestBD.setNombre(request.getNombre());
				requestBD.setApellido(request.getApellido());
				requestBD.setProcesado(false);
			}else {
				errorResponse.setMensaje(EXCEPTION_BAD_RQ_CLIENT);
				errorResponse.setStatus(BAD_REQUEST_STATUS);
				return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
			}	
			return new ResponseEntity<>(clientService.save(requestBD), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(EXCEPTION_FINDBYID_CLIENT, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> findById(ClientSaveRequestDTO request) {
		ErrorDTO errorResponse = new ErrorDTO();
		try {
			if(request.getId() == 0 ) {
				errorResponse.setMensaje(EXCEPTION_BAD_RQ_CLIENT_ID);
				errorResponse.setStatus(BAD_REQUEST_STATUS);
				
				return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
			}else {
				
				ModelClientEntity response= clientService.findById(request.getId());
				if(response != null) {
					response.setNombre(request.getNombre());
					response.setApellido(request.getApellido());
					response.setProcesado(true);
					return new ResponseEntity<>(clientService.save(response), HttpStatus.OK);
				}else {
					errorResponse.setMensaje(EXCEPTION_FINDBYID_CLIENT_BD);
					errorResponse.setStatus(BAD_REQUEST_STATUS);
					return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
				}
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(EXCEPTION_FINDBYID_CLIENT, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
