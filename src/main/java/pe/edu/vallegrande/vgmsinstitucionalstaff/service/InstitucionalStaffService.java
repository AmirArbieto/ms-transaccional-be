package pe.edu.vallegrande.vgmsinstitucionalstaff.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.InstitucionalStaff;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InstitucionalStaffService {

    Mono<InstitucionalStaff> create(InstitucionalStaff institucionalStaff);
    Mono<InstitucionalStaff> update(String id, InstitucionalStaff institucionalStaff);
    Mono<InstitucionalStaff> activate(String id);
    Mono<InstitucionalStaff> deactivate(String id);
    Mono<InstitucionalStaff> getById(String id);
    Flux<InstitucionalStaff> getAll();
    Mono<Page<InstitucionalStaff>> getAllActive(Pageable pageable);
    Flux<InstitucionalStaff> getAllInactive();

}
