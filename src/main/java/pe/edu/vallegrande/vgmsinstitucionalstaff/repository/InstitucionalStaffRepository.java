package pe.edu.vallegrande.vgmsinstitucionalstaff.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.InstitucionalStaff;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InstitucionalStaffRepository extends ReactiveMongoRepository<InstitucionalStaff, String>, ReactiveSortingRepository<InstitucionalStaff, String> {

    Flux<InstitucionalStaff> findByState(String state);
    Flux<InstitucionalStaff> findByState(String state, Pageable pageable);
    Mono<Long> countByState(String state);
}
