package pe.edu.vallegrande.vgmsinstitucionalstaff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.InstitucionalStaff;
import pe.edu.vallegrande.vgmsinstitucionalstaff.repository.InstitucionalStaffRepository;
import pe.edu.vallegrande.vgmsinstitucionalstaff.service.InstitucionalStaffService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class InstitucionalStaffServiceImpl implements InstitucionalStaffService {

    private final InstitucionalStaffRepository institucionalStaffRepository;

    @Override
    public Mono<InstitucionalStaff> create(InstitucionalStaff institucionalStaff) {
        return institucionalStaffRepository.save(institucionalStaff);
    }

    @Override
    public Mono<InstitucionalStaff> update(String id, InstitucionalStaff institucionalStaff) {
        return institucionalStaffRepository.findById(id)
                .flatMap(staff -> {
                    staff.setName(institucionalStaff.getName());
                    staff.setFather_lastname(institucionalStaff.getFather_lastname());
                    staff.setMother_lastname(institucionalStaff.getMother_lastname());
                    staff.setDocument_type(institucionalStaff.getDocument_type());
                    staff.setDocument_number(institucionalStaff.getDocument_number());
                    staff.setSex(institucionalStaff.getSex());
                    staff.setCountry(institucionalStaff.getCountry());
                    staff.setEmail(institucionalStaff.getEmail());
                    staff.setPhone(institucionalStaff.getPhone());
                    staff.setCivil_status(institucionalStaff.getCivil_status());
                    staff.setInstruction_grade(institucionalStaff.getInstruction_grade());
                    staff.setDisability_type(institucionalStaff.getDisability_type());
                    staff.setDisability(institucionalStaff.getDisability());
                    staff.setWork_condition(institucionalStaff.getWork_condition());
                    staff.setOccupation(institucionalStaff.getOccupation());
                    staff.setNative_language(institucionalStaff.getNative_language());
                    staff.setAddress(institucionalStaff.getAddress());
                    return institucionalStaffRepository.save(staff);
                });
    }

    @Override
    public Mono<InstitucionalStaff> activate(String id) {
        return institucionalStaffRepository.findById(id)
                .flatMap(staff -> {
                    staff.setState("A");
                    return institucionalStaffRepository.save(staff);
                });
    }

    @Override
    public Mono<InstitucionalStaff> deactivate(String id) {
        return institucionalStaffRepository.findById(id)
                .flatMap(staff -> {
                    staff.setState("I");
                    return institucionalStaffRepository.save(staff);
                });
    }

    @Override
    public Mono<InstitucionalStaff> getById(String id) {
        return institucionalStaffRepository.findById(id);
    }

    @Override
    public Flux<InstitucionalStaff> getAll() {
        return institucionalStaffRepository.findAll();
    }

    @Override
    public Mono<Page<InstitucionalStaff>> getAllActive(Pageable pageable) {
        return institucionalStaffRepository.findByState("A",pageable)
                .collectList()
                .zipWith(institucionalStaffRepository.countByState("A"))
                .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2()));
    }

    @Override
    public Flux<InstitucionalStaff> getAllInactive() {
        return institucionalStaffRepository.findByState("I");
    }
}
