package pe.edu.vallegrande.vgmsinstitucionalstaff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.InstitucionalStaff;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.Ubigeo;
import pe.edu.vallegrande.vgmsinstitucionalstaff.repository.InstitucionalStaffRepository;
import pe.edu.vallegrande.vgmsinstitucionalstaff.repository.UbigeoRepository;
import pe.edu.vallegrande.vgmsinstitucionalstaff.service.InstitucionalStaffService;
import pe.edu.vallegrande.vgmsinstitucionalstaff.service.UbigeoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl implements UbigeoService {

    private final UbigeoRepository ubigeoRepository;


    @Override
    public Flux<Ubigeo> getAll() {
        return ubigeoRepository.findAll();
    }
}
