package co.com.clients.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.clients.model.entity.ModelClientEntity;
import co.com.clients.model.request.ClientSaveRequestDTO;
import co.com.clients.repository.ClientRepository;
import co.com.clients.service.ClientService;
import static co.com.clients.router.RouterConsts.*;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<Object> findAll() {
		try {
			return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(EXCEPTION_FINDALL_CLIENT, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> save(ModelClientEntity request) {
		try {	
			return new ResponseEntity<>(clientRepository.save(request), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(EXCEPTION_SAVE_CLIENT, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ModelClientEntity findById(Long id) {
			return clientRepository.findById(id).orElse(null);
	}

}
