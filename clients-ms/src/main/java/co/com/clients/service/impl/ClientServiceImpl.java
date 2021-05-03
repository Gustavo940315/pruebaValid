package co.com.clients.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.clients.model.entity.ModelClientEntity;
import co.com.clients.model.error.ErrorDTO;
import co.com.clients.model.request.ClientSaveRequestDTO;
import co.com.clients.repository.ClientRepository;
import co.com.clients.service.ClientService;
import static co.com.clients.router.RouterConsts.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	@Transactional(readOnly=true)
	public List<ModelClientEntity> findAll() {
			return (List<ModelClientEntity>) clientRepository.findAll();

	}

	@Override
	public ResponseEntity<Object> save(ModelClientEntity request) {
			return new ResponseEntity<>(clientRepository.save(request), HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly=true)
	public ModelClientEntity findById(Long id) {
			return clientRepository.findById(id).orElse(null);
	}

}
