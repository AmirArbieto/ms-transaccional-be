package pe.edu.vallegrande.vgmsinstitucionalstaff.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.Ubigeo;

public interface UbigeoRepository extends ReactiveMongoRepository<Ubigeo, String> {

}
