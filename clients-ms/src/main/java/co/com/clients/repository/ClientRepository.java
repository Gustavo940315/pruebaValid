package co.com.clients.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.clients.model.entity.ModelClientEntity;
@Repository
public interface ClientRepository extends CrudRepository<ModelClientEntity, Long> {

}
